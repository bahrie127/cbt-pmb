package com.bahri.pmb.ui.controller;

import com.bahri.pmb.domain.Jawaban;
import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.domain.Soal;
import com.bahri.pmb.domain.UploadItem;
import com.bahri.pmb.service.JawabanService;
import com.bahri.pmb.service.KategoriService;
import com.bahri.pmb.service.SoalService;
import com.bahri.pmb.service.editor.JawabanEditor;
import com.bahri.pmb.service.editor.KategoriEditor;
import com.bahri.pmb.service.editor.SoalEditor;
import com.bahri.pmb.simple.SimpleSoal;
import com.bahri.pmb.util.ConstantUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "soal")
public class SoalController implements HandlerExceptionResolver {

    @Autowired
    @Qualifier("soalService")
    private SoalService soalService;

    @Autowired
    @Qualifier("jawabanService")
    private JawabanService jawabanService;

    @Autowired
    @Qualifier("kategoriService")
    private KategoriService kategoriService;

    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String navBar() {
        return "soal/navbar";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String formUpload(ModelMap modelMap) {
        modelMap.addAttribute("uploadItem", new UploadItem());
        return "soal/upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String create(UploadItem uploadItem, BindingResult result, HttpServletRequest request) throws BiffException, IOException {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error: " + error.getCode() + " - "
                        + error.getDefaultMessage());
            }
            return "/uploadfile";
        }

        // Some type of file processing...
        System.err.println("-------------------------------------------");
        try {
            MultipartFile file = uploadItem.getFileData();


            String fileName = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            if (file.getSize() > 0) {
                inputStream = file.getInputStream();
                if (file.getSize() > 10000) {
                    System.out.println("File Size:::" + file.getSize());
                    return "/uploadfile";
                }
                System.out.println("size::" + file.getSize());
                fileName = request.getRealPath("") + "/resources/"
                        + file.getOriginalFilename();
                outputStream = new FileOutputStream(fileName);
                System.out.println("fileName:" + file.getOriginalFilename());

                int readBytes = 0;
                byte[] buffer = new byte[10000];
                while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.close();
                inputStream.close();
            }

            File excel = new File(fileName);

            Workbook w = Workbook.getWorkbook(excel);
            String pertanyaan = null;
            Long idKategori = null;
            String jawabanA = null;
            String jawabanB = null;
            String jawabanC = null;
            String jawabanD = null;
            String kunci = null;

            Sheet sheet = w.getSheet(0);
            for (int j = 0; j < sheet.getRows(); j++) {
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    if (j != 0) {
                        if (i == 0) {
                            pertanyaan = cell.getContents();
                        }
                        if (i == 1) {
                            idKategori = Long.parseLong(cell.getContents());
                        }
                        if (i == 2) {
                            jawabanA = cell.getContents();
                        }
                        if (i == 3) {
                            jawabanB = cell.getContents();
                        }
                        if (i == 4) {
                            jawabanC = cell.getContents();
                        }
                        if (i == 5) {
                            jawabanD = cell.getContents();
                        }
                        if (i == 6) {
                            kunci = cell.getContents();
                        }

                    }
                }
                if (j != 0) {
                    SimpleSoal simpleSoal = new SimpleSoal();
                    simpleSoal.setPertanyaan(pertanyaan);
                    simpleSoal.setIdKategori(idKategori);
                    simpleSoal.setJawabanA(jawabanA);
                    simpleSoal.setJawabanB(jawabanB);
                    simpleSoal.setJawabanC(jawabanC);
                    simpleSoal.setJawabanD(jawabanD);
                    simpleSoal.setKebenaran(kunci);
                    soalService.save(simpleSoal.convertToSoal());
                }
            }

        } catch (Exception e) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam(required = false, value = "page", defaultValue = "1") int page) {
        int countPage = soalService.countPageSoals();
        page = (page < 1 ? 1 : (page > countPage ? countPage : page));
        modelMap.addAttribute("soals", soalService.findSoals(page));
        modelMap.addAttribute("countPage", countPage);
        modelMap.addAttribute("kiri", ConstantUtils.leftRightPagination(page, countPage)[0]);
        modelMap.addAttribute("kanan", ConstantUtils.leftRightPagination(page, countPage)[1]);
        modelMap.addAttribute("page", page);

        modelMap.addAttribute("urlFunction", "/soal");
        return "soal/list";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String find(ModelMap modelMap, @RequestParam("id") Soal soal) {
        modelMap.addAttribute("event", "DETAIL");
        modelMap.addAttribute("soal", soal);
        return "soal/input";
    }

    @RequestMapping(params = "id", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String delete(@RequestParam("id") Soal soal) {
        try {
            soalService.delete(soal);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("event", "INPUT");
        modelMap.addAttribute("httpMethod", "POST");
        modelMap.addAttribute("kategoriList", kategoriService.findKategoris());
        modelMap.addAttribute("soal", new SimpleSoal());

        return "soal/input";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String save(@Valid @ModelAttribute("soal") SimpleSoal soal, BindingResult bindingResult, ModelMap modelMap) {
        if (soal == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";

        try {
            soalService.save(soal.convertToSoal());
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"content-type=application/json"})
    public
    @ResponseBody
    String save(@RequestBody Soal soal) {
        System.out.println(soal);
        if (soal == null) return "Gagal";

        try {
            soalService.save(soal);
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @RequestMapping(value = "edit", params = "id", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @RequestParam("id") Soal soal) {

        modelMap.addAttribute("event", "EDIT");
        modelMap.addAttribute("httpMethod", "PUT");
        modelMap.addAttribute("kategoriList", kategoriService.findKategoris());
        modelMap.addAttribute("soal", soal.convertToSimpleSoal());
        return "soal/input";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    String update(@Valid @ModelAttribute("soal") SimpleSoal soal, BindingResult bindingResult, ModelMap modelMap) {

        if (soal == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";

        try {
            soalService.save(soal.convertToSoal());
            System.out.println();
            return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Soal.class, new SoalEditor(soalService));
        binder.registerCustomEditor(Kategori.class, new KategoriEditor(kategoriService));
        binder.registerCustomEditor(Jawaban.class, new JawabanEditor(jawabanService));

    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<Object, Object> model = new HashMap<Object, Object>();
        if (e instanceof MaxUploadSizeExceededException) {
            model.put("errors", "File size should be less then " +
                    ((MaxUploadSizeExceededException) e).getMaxUploadSize() + " byte.");
        } else {
            model.put("errors", "Unexpected error: " + e.getMessage());
        }
        model.put("FORM", new UploadItem());
        return new ModelAndView("/admin/dashboard", (Map) model);
    }
}
