package com.secondstack.flatoutstore.simple.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/15/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestRoleGroup {

    private Long id;
    private String name;

    private boolean home=false;

    private boolean bankC = false;
    private boolean bankR = false;
    private boolean bankU = false;
    private boolean bankD = false;

    private boolean cashC = false;
    private boolean cashR = false;
    private boolean cashU = false;
    private boolean cashD = false;

    private boolean depositC = false;
    private boolean depositR = false;
    private boolean depositU = false;
    private boolean depositD = false;

    private boolean diskonC = false;
    private boolean diskonR = false;
    private boolean diskonU = false;
    private boolean diskonD = false;

    private boolean distributorC = false;
    private boolean distributorR = false;
    private boolean distributorU = false;
    private boolean distributorD = false;

    private boolean kategoriC = false;
    private boolean kategoriR = false;
    private boolean kategoriU = false;
    private boolean kategoriD = false;

    private boolean merekC = false;
    private boolean merekR = false;
    private boolean merekU = false;
    private boolean merekD = false;

    private boolean ongkosKirimC = false;
    private boolean ongkosKirimR = false;
    private boolean ongkosKirimU = false;
    private boolean ongkosKirimD = false;

    private boolean pelangganC = false;
    private boolean pelangganR = false;
    private boolean pelangganU = false;
    private boolean pelangganD = false;

    private boolean pembelianC = false;
    private boolean pembelianR = false;
    private boolean pembelianU = false;
    private boolean pembelianD = false;

    private boolean penjualanC = false;
    private boolean penjualanR = false;
    private boolean penjualanU = false;
    private boolean penjualanD = false;

    private boolean tipeC = false;
    private boolean tipeR = false;
    private boolean tipeU = false;
    private boolean tipeD = false;

    private boolean transaksiC = false;
    private boolean transaksiR = false;
    private boolean transaksiU = false;
    private boolean transaksiD = false;

    private boolean ukuranC = false;
    private boolean ukuranR = false;
    private boolean ukuranU = false;
    private boolean ukuranD = false;

    private boolean warnaC = false;
    private boolean warnaR = false;
    private boolean warnaU = false;
    private boolean warnaD = false;

    private boolean userC = false;
    private boolean userR = false;
    private boolean userU = false;
    private boolean userD = false;

    private boolean roleGroupC = false;
    private boolean roleGroupR = false;
    private boolean roleGroupU = false;
    private boolean roleGroupD = false;

    private boolean reportC = false;
    private boolean reportR = false;
    private boolean reportU = false;
    private boolean reportD = false;

    public RequestRoleGroup() {
    }

    public RequestRoleGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBankC() {
        return bankC;
    }

    public void setBankC(boolean bankC) {
        this.bankC = bankC;
    }

    public boolean isBankR() {
        return bankR;
    }

    public void setBankR(boolean bankR) {
        this.bankR = bankR;
    }

    public boolean isBankU() {
        return bankU;
    }

    public void setBankU(boolean bankU) {
        this.bankU = bankU;
    }

    public boolean isBankD() {
        return bankD;
    }

    public void setBankD(boolean bankD) {
        this.bankD = bankD;
    }

    public boolean isCashC() {
        return cashC;
    }

    public void setCashC(boolean cashC) {
        this.cashC = cashC;
    }

    public boolean isCashR() {
        return cashR;
    }

    public void setCashR(boolean cashR) {
        this.cashR = cashR;
    }

    public boolean isCashU() {
        return cashU;
    }

    public void setCashU(boolean cashU) {
        this.cashU = cashU;
    }

    public boolean isCashD() {
        return cashD;
    }

    public void setCashD(boolean cashD) {
        this.cashD = cashD;
    }

    public boolean isDepositC() {
        return depositC;
    }

    public void setDepositC(boolean depositC) {
        this.depositC = depositC;
    }

    public boolean isDepositR() {
        return depositR;
    }

    public void setDepositR(boolean depositR) {
        this.depositR = depositR;
    }

    public boolean isDepositU() {
        return depositU;
    }

    public void setDepositU(boolean depositU) {
        this.depositU = depositU;
    }

    public boolean isDepositD() {
        return depositD;
    }

    public void setDepositD(boolean depositD) {
        this.depositD = depositD;
    }

    public boolean isDiskonC() {
        return diskonC;
    }

    public void setDiskonC(boolean diskonC) {
        this.diskonC = diskonC;
    }

    public boolean isDiskonR() {
        return diskonR;
    }

    public void setDiskonR(boolean diskonR) {
        this.diskonR = diskonR;
    }

    public boolean isDiskonU() {
        return diskonU;
    }

    public void setDiskonU(boolean diskonU) {
        this.diskonU = diskonU;
    }

    public boolean isDiskonD() {
        return diskonD;
    }

    public void setDiskonD(boolean diskonD) {
        this.diskonD = diskonD;
    }

    public boolean isDistributorC() {
        return distributorC;
    }

    public void setDistributorC(boolean distributorC) {
        this.distributorC = distributorC;
    }

    public boolean isDistributorR() {
        return distributorR;
    }

    public void setDistributorR(boolean distributorR) {
        this.distributorR = distributorR;
    }

    public boolean isDistributorU() {
        return distributorU;
    }

    public void setDistributorU(boolean distributorU) {
        this.distributorU = distributorU;
    }

    public boolean isDistributorD() {
        return distributorD;
    }

    public void setDistributorD(boolean distributorD) {
        this.distributorD = distributorD;
    }

    public boolean isKategoriC() {
        return kategoriC;
    }

    public void setKategoriC(boolean kategoriC) {
        this.kategoriC = kategoriC;
    }

    public boolean isKategoriR() {
        return kategoriR;
    }

    public void setKategoriR(boolean kategoriR) {
        this.kategoriR = kategoriR;
    }

    public boolean isKategoriU() {
        return kategoriU;
    }

    public void setKategoriU(boolean kategoriU) {
        this.kategoriU = kategoriU;
    }

    public boolean isKategoriD() {
        return kategoriD;
    }

    public void setKategoriD(boolean kategoriD) {
        this.kategoriD = kategoriD;
    }

    public boolean isMerekC() {
        return merekC;
    }

    public void setMerekC(boolean merekC) {
        this.merekC = merekC;
    }

    public boolean isMerekR() {
        return merekR;
    }

    public void setMerekR(boolean merekR) {
        this.merekR = merekR;
    }

    public boolean isMerekU() {
        return merekU;
    }

    public void setMerekU(boolean merekU) {
        this.merekU = merekU;
    }

    public boolean isMerekD() {
        return merekD;
    }

    public void setMerekD(boolean merekD) {
        this.merekD = merekD;
    }

    public boolean isOngkosKirimC() {
        return ongkosKirimC;
    }

    public void setOngkosKirimC(boolean ongkosKirimC) {
        this.ongkosKirimC = ongkosKirimC;
    }

    public boolean isOngkosKirimR() {
        return ongkosKirimR;
    }

    public void setOngkosKirimR(boolean ongkosKirimR) {
        this.ongkosKirimR = ongkosKirimR;
    }

    public boolean isOngkosKirimU() {
        return ongkosKirimU;
    }

    public void setOngkosKirimU(boolean ongkosKirimU) {
        this.ongkosKirimU = ongkosKirimU;
    }

    public boolean isOngkosKirimD() {
        return ongkosKirimD;
    }

    public void setOngkosKirimD(boolean ongkosKirimD) {
        this.ongkosKirimD = ongkosKirimD;
    }

    public boolean isPelangganC() {
        return pelangganC;
    }

    public void setPelangganC(boolean pelangganC) {
        this.pelangganC = pelangganC;
    }

    public boolean isPelangganR() {
        return pelangganR;
    }

    public void setPelangganR(boolean pelangganR) {
        this.pelangganR = pelangganR;
    }

    public boolean isPelangganU() {
        return pelangganU;
    }

    public void setPelangganU(boolean pelangganU) {
        this.pelangganU = pelangganU;
    }

    public boolean isPelangganD() {
        return pelangganD;
    }

    public void setPelangganD(boolean pelangganD) {
        this.pelangganD = pelangganD;
    }

    public boolean isPembelianC() {
        return pembelianC;
    }

    public void setPembelianC(boolean pembelianC) {
        this.pembelianC = pembelianC;
    }

    public boolean isPembelianR() {
        return pembelianR;
    }

    public void setPembelianR(boolean pembelianR) {
        this.pembelianR = pembelianR;
    }

    public boolean isPembelianU() {
        return pembelianU;
    }

    public void setPembelianU(boolean pembelianU) {
        this.pembelianU = pembelianU;
    }

    public boolean isPembelianD() {
        return pembelianD;
    }

    public void setPembelianD(boolean pembelianD) {
        this.pembelianD = pembelianD;
    }

    public boolean isPenjualanC() {
        return penjualanC;
    }

    public void setPenjualanC(boolean penjualanC) {
        this.penjualanC = penjualanC;
    }

    public boolean isPenjualanR() {
        return penjualanR;
    }

    public void setPenjualanR(boolean penjualanR) {
        this.penjualanR = penjualanR;
    }

    public boolean isPenjualanU() {
        return penjualanU;
    }

    public void setPenjualanU(boolean penjualanU) {
        this.penjualanU = penjualanU;
    }

    public boolean isPenjualanD() {
        return penjualanD;
    }

    public void setPenjualanD(boolean penjualanD) {
        this.penjualanD = penjualanD;
    }

    public boolean isTipeC() {
        return tipeC;
    }

    public void setTipeC(boolean tipeC) {
        this.tipeC = tipeC;
    }

    public boolean isTipeR() {
        return tipeR;
    }

    public void setTipeR(boolean tipeR) {
        this.tipeR = tipeR;
    }

    public boolean isTipeU() {
        return tipeU;
    }

    public void setTipeU(boolean tipeU) {
        this.tipeU = tipeU;
    }

    public boolean isTipeD() {
        return tipeD;
    }

    public void setTipeD(boolean tipeD) {
        this.tipeD = tipeD;
    }

    public boolean isTransaksiC() {
        return transaksiC;
    }

    public void setTransaksiC(boolean transaksiC) {
        this.transaksiC = transaksiC;
    }

    public boolean isTransaksiR() {
        return transaksiR;
    }

    public void setTransaksiR(boolean transaksiR) {
        this.transaksiR = transaksiR;
    }

    public boolean isTransaksiU() {
        return transaksiU;
    }

    public void setTransaksiU(boolean transaksiU) {
        this.transaksiU = transaksiU;
    }

    public boolean isTransaksiD() {
        return transaksiD;
    }

    public void setTransaksiD(boolean transaksiD) {
        this.transaksiD = transaksiD;
    }

    public boolean isUkuranC() {
        return ukuranC;
    }

    public void setUkuranC(boolean ukuranC) {
        this.ukuranC = ukuranC;
    }

    public boolean isUkuranR() {
        return ukuranR;
    }

    public void setUkuranR(boolean ukuranR) {
        this.ukuranR = ukuranR;
    }

    public boolean isUkuranU() {
        return ukuranU;
    }

    public void setUkuranU(boolean ukuranU) {
        this.ukuranU = ukuranU;
    }

    public boolean isUkuranD() {
        return ukuranD;
    }

    public void setUkuranD(boolean ukuranD) {
        this.ukuranD = ukuranD;
    }

    public boolean isWarnaC() {
        return warnaC;
    }

    public void setWarnaC(boolean warnaC) {
        this.warnaC = warnaC;
    }

    public boolean isWarnaR() {
        return warnaR;
    }

    public void setWarnaR(boolean warnaR) {
        this.warnaR = warnaR;
    }

    public boolean isWarnaU() {
        return warnaU;
    }

    public void setWarnaU(boolean warnaU) {
        this.warnaU = warnaU;
    }

    public boolean isWarnaD() {
        return warnaD;
    }

    public void setWarnaD(boolean warnaD) {
        this.warnaD = warnaD;
    }

    public boolean isReportC() {
        return reportC;
    }

    public boolean isUserC() {
        return userC;
    }

    public void setUserC(boolean userC) {
        this.userC = userC;
    }

    public boolean isUserR() {
        return userR;
    }

    public void setUserR(boolean userR) {
        this.userR = userR;
    }

    public boolean isUserU() {
        return userU;
    }

    public void setUserU(boolean userU) {
        this.userU = userU;
    }

    public boolean isUserD() {
        return userD;
    }

    public void setUserD(boolean userD) {
        this.userD = userD;
    }

    public boolean isRoleGroupC() {
        return roleGroupC;
    }

    public void setRoleGroupC(boolean roleGroupC) {
        this.roleGroupC = roleGroupC;
    }

    public boolean isRoleGroupR() {
        return roleGroupR;
    }

    public void setRoleGroupR(boolean roleGroupR) {
        this.roleGroupR = roleGroupR;
    }

    public boolean isRoleGroupU() {
        return roleGroupU;
    }

    public void setRoleGroupU(boolean roleGroupU) {
        this.roleGroupU = roleGroupU;
    }

    public boolean isRoleGroupD() {
        return roleGroupD;
    }

    public void setRoleGroupD(boolean roleGroupD) {
        this.roleGroupD = roleGroupD;
    }

    public void setReportC(boolean reportC) {
        this.reportC = reportC;
    }

    public boolean isReportR() {
        return reportR;
    }

    public void setReportR(boolean reportR) {
        this.reportR = reportR;
    }

    public boolean isReportU() {
        return reportU;
    }

    public void setReportU(boolean reportU) {
        this.reportU = reportU;
    }

    public boolean isReportD() {
        return reportD;
    }

    public void setReportD(boolean reportD) {
        this.reportD = reportD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestRoleGroup that = (RequestRoleGroup) o;

        if (home != that.home) return false;
        if (bankC != that.bankC) return false;
        if (bankD != that.bankD) return false;
        if (bankR != that.bankR) return false;
        if (bankU != that.bankU) return false;
        if (cashC != that.cashC) return false;
        if (cashD != that.cashD) return false;
        if (cashR != that.cashR) return false;
        if (cashU != that.cashU) return false;
        if (depositC != that.depositC) return false;
        if (depositD != that.depositD) return false;
        if (depositR != that.depositR) return false;
        if (depositU != that.depositU) return false;
        if (diskonC != that.diskonC) return false;
        if (diskonD != that.diskonD) return false;
        if (diskonR != that.diskonR) return false;
        if (diskonU != that.diskonU) return false;
        if (distributorC != that.distributorC) return false;
        if (distributorD != that.distributorD) return false;
        if (distributorR != that.distributorR) return false;
        if (distributorU != that.distributorU) return false;
        if (kategoriC != that.kategoriC) return false;
        if (kategoriD != that.kategoriD) return false;
        if (kategoriR != that.kategoriR) return false;
        if (kategoriU != that.kategoriU) return false;
        if (merekC != that.merekC) return false;
        if (merekD != that.merekD) return false;
        if (merekR != that.merekR) return false;
        if (merekU != that.merekU) return false;
        if (ongkosKirimC != that.ongkosKirimC) return false;
        if (ongkosKirimD != that.ongkosKirimD) return false;
        if (ongkosKirimR != that.ongkosKirimR) return false;
        if (ongkosKirimU != that.ongkosKirimU) return false;
        if (pelangganC != that.pelangganC) return false;
        if (pelangganD != that.pelangganD) return false;
        if (pelangganR != that.pelangganR) return false;
        if (pelangganU != that.pelangganU) return false;
        if (pembelianC != that.pembelianC) return false;
        if (pembelianD != that.pembelianD) return false;
        if (pembelianR != that.pembelianR) return false;
        if (pembelianU != that.pembelianU) return false;
        if (penjualanC != that.penjualanC) return false;
        if (penjualanD != that.penjualanD) return false;
        if (penjualanR != that.penjualanR) return false;
        if (penjualanU != that.penjualanU) return false;
        if (reportC != that.reportC) return false;
        if (reportD != that.reportD) return false;
        if (reportR != that.reportR) return false;
        if (reportU != that.reportU) return false;
        if (tipeC != that.tipeC) return false;
        if (tipeD != that.tipeD) return false;
        if (tipeR != that.tipeR) return false;
        if (tipeU != that.tipeU) return false;
        if (transaksiC != that.transaksiC) return false;
        if (transaksiD != that.transaksiD) return false;
        if (transaksiR != that.transaksiR) return false;
        if (transaksiU != that.transaksiU) return false;
        if (ukuranC != that.ukuranC) return false;
        if (ukuranD != that.ukuranD) return false;
        if (ukuranR != that.ukuranR) return false;
        if (ukuranU != that.ukuranU) return false;
        if (warnaC != that.warnaC) return false;
        if (warnaD != that.warnaD) return false;
        if (warnaR != that.warnaR) return false;
        if (warnaU != that.warnaU) return false;
        if (userC != that.userC) return false;
        if (userD != that.userD) return false;
        if (userR != that.userR) return false;
        if (userU != that.userU) return false;
        if (roleGroupC != that.roleGroupC) return false;
        if (roleGroupD != that.roleGroupD) return false;
        if (roleGroupR != that.roleGroupR) return false;
        if (roleGroupU != that.roleGroupU) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (home ? 1 : 0);
        result = 31 * result + (bankC ? 1 : 0);
        result = 31 * result + (bankR ? 1 : 0);
        result = 31 * result + (bankU ? 1 : 0);
        result = 31 * result + (bankD ? 1 : 0);
        result = 31 * result + (cashC ? 1 : 0);
        result = 31 * result + (cashR ? 1 : 0);
        result = 31 * result + (cashU ? 1 : 0);
        result = 31 * result + (cashD ? 1 : 0);
        result = 31 * result + (depositC ? 1 : 0);
        result = 31 * result + (depositR ? 1 : 0);
        result = 31 * result + (depositU ? 1 : 0);
        result = 31 * result + (depositD ? 1 : 0);
        result = 31 * result + (diskonC ? 1 : 0);
        result = 31 * result + (diskonR ? 1 : 0);
        result = 31 * result + (diskonU ? 1 : 0);
        result = 31 * result + (diskonD ? 1 : 0);
        result = 31 * result + (distributorC ? 1 : 0);
        result = 31 * result + (distributorR ? 1 : 0);
        result = 31 * result + (distributorU ? 1 : 0);
        result = 31 * result + (distributorD ? 1 : 0);
        result = 31 * result + (kategoriC ? 1 : 0);
        result = 31 * result + (kategoriR ? 1 : 0);
        result = 31 * result + (kategoriU ? 1 : 0);
        result = 31 * result + (kategoriD ? 1 : 0);
        result = 31 * result + (merekC ? 1 : 0);
        result = 31 * result + (merekR ? 1 : 0);
        result = 31 * result + (merekU ? 1 : 0);
        result = 31 * result + (merekD ? 1 : 0);
        result = 31 * result + (ongkosKirimC ? 1 : 0);
        result = 31 * result + (ongkosKirimR ? 1 : 0);
        result = 31 * result + (ongkosKirimU ? 1 : 0);
        result = 31 * result + (ongkosKirimD ? 1 : 0);
        result = 31 * result + (pelangganC ? 1 : 0);
        result = 31 * result + (pelangganR ? 1 : 0);
        result = 31 * result + (pelangganU ? 1 : 0);
        result = 31 * result + (pelangganD ? 1 : 0);
        result = 31 * result + (pembelianC ? 1 : 0);
        result = 31 * result + (pembelianR ? 1 : 0);
        result = 31 * result + (pembelianU ? 1 : 0);
        result = 31 * result + (pembelianD ? 1 : 0);
        result = 31 * result + (penjualanC ? 1 : 0);
        result = 31 * result + (penjualanR ? 1 : 0);
        result = 31 * result + (penjualanU ? 1 : 0);
        result = 31 * result + (penjualanD ? 1 : 0);
        result = 31 * result + (tipeC ? 1 : 0);
        result = 31 * result + (tipeR ? 1 : 0);
        result = 31 * result + (tipeU ? 1 : 0);
        result = 31 * result + (tipeD ? 1 : 0);
        result = 31 * result + (transaksiC ? 1 : 0);
        result = 31 * result + (transaksiR ? 1 : 0);
        result = 31 * result + (transaksiU ? 1 : 0);
        result = 31 * result + (transaksiD ? 1 : 0);
        result = 31 * result + (ukuranC ? 1 : 0);
        result = 31 * result + (ukuranR ? 1 : 0);
        result = 31 * result + (ukuranU ? 1 : 0);
        result = 31 * result + (ukuranD ? 1 : 0);
        result = 31 * result + (warnaC ? 1 : 0);
        result = 31 * result + (warnaR ? 1 : 0);
        result = 31 * result + (warnaU ? 1 : 0);
        result = 31 * result + (warnaD ? 1 : 0);
        result = 31 * result + (userC ? 1 : 0);
        result = 31 * result + (userR ? 1 : 0);
        result = 31 * result + (userU ? 1 : 0);
        result = 31 * result + (userD ? 1 : 0);
        result = 31 * result + (roleGroupC ? 1 : 0);
        result = 31 * result + (roleGroupR ? 1 : 0);
        result = 31 * result + (roleGroupU ? 1 : 0);
        result = 31 * result + (roleGroupD ? 1 : 0);
        result = 31 * result + (reportC ? 1 : 0);
        result = 31 * result + (reportR ? 1 : 0);
        result = 31 * result + (reportU ? 1 : 0);
        result = 31 * result + (reportD ? 1 : 0);
        return result;
    }

    public RoleGroup convertToRoleGroup(){
        RoleGroup roleGroup = new RoleGroup(id, name);

        List<Role> roles = new ArrayList<Role>();

        if (home){roles.add(new Role("HOME"));}
        if (bankC){roles.add(new Role("BANK_C"));}
        if (bankR){roles.add(new Role("BANK_R"));}
        if (bankU){roles.add(new Role("BANK_U"));}
        if (bankD){roles.add(new Role("BANK_D"));}
        if (cashC){roles.add(new Role("CASH_C"));}
        if (cashR){roles.add(new Role("CASH_R"));}
        if (cashU){roles.add(new Role("CASH_U"));}
        if (cashD){roles.add(new Role("CASH_D"));}
        if (depositC){roles.add(new Role("DEPOSIT_C"));}
        if (depositR){roles.add(new Role("DEPOSIT_R"));}
        if (depositU){roles.add(new Role("DEPOSIT_U"));}
        if (depositD){roles.add(new Role("DEPOSIT_D"));}
        if (diskonC){roles.add(new Role("DISKON_C"));}
        if (diskonR){roles.add(new Role("DISKON_R"));}
        if (diskonU){roles.add(new Role("DISKON_U"));}
        if (diskonD){roles.add(new Role("DISKON_D"));}
        if (distributorC){roles.add(new Role("DISTRIBUTOR_C"));}
        if (distributorR){roles.add(new Role("DISTRIBUTOR_R"));}
        if (distributorU){roles.add(new Role("DISTRIBUTOR_U"));}
        if (distributorD){roles.add(new Role("DISTRIBUTOR_D"));}
        if (kategoriC){roles.add(new Role("KATEGORI_C"));}
        if (kategoriR){roles.add(new Role("KATEGORI_R"));}
        if (kategoriU){roles.add(new Role("KATEGORI_U"));}
        if (kategoriD){roles.add(new Role("KATEGORI_D"));}
        if (merekC){roles.add(new Role("MEREK_C"));}
        if (merekR){roles.add(new Role("MEREK_R"));}
        if (merekU){roles.add(new Role("MEREK_U"));}
        if (merekD){roles.add(new Role("MEREK_D"));}
        if (ongkosKirimC){roles.add(new Role("ONGKOS_KIRIM_C"));}
        if (ongkosKirimR){roles.add(new Role("ONGKOS_KIRIM_R"));}
        if (ongkosKirimU){roles.add(new Role("ONGKOS_KIRIM_U"));}
        if (ongkosKirimD){roles.add(new Role("ONGKOS_KIRIM_D"));}
        if (pelangganC){roles.add(new Role("PELANGGAN_C"));}
        if (pelangganR){roles.add(new Role("PELANGGAN_R"));}
        if (pelangganU){roles.add(new Role("PELANGGAN_U"));}
        if (pelangganD){roles.add(new Role("PELANGGAN_D"));}
        if (pembelianC){roles.add(new Role("PEMBELIAN_C"));}
        if (pembelianR){roles.add(new Role("PEMBELIAN_R"));}
        if (pembelianU){roles.add(new Role("PEMBELIAN_U"));}
        if (pembelianD){roles.add(new Role("PEMBELIAN_D"));}
        if (penjualanC){roles.add(new Role("PENJUALAN_C"));}
        if (penjualanR){roles.add(new Role("PENJUALAN_R"));}
        if (penjualanU){roles.add(new Role("PENJUALAN_U"));}
        if (penjualanD){roles.add(new Role("PENJUALAN_D"));}
        if (tipeC){roles.add(new Role("TIPE_C"));}
        if (tipeR){roles.add(new Role("TIPE_R"));}
        if (tipeU){roles.add(new Role("TIPE_U"));}
        if (tipeD){roles.add(new Role("TIPE_D"));}
        if (transaksiC){roles.add(new Role("TRANSAKSI_C"));}
        if (transaksiR){roles.add(new Role("TRANSAKSI_R"));}
        if (transaksiU){roles.add(new Role("TRANSAKSI_U"));}
        if (transaksiD){roles.add(new Role("TRANSAKSI_D"));}
        if (ukuranC){roles.add(new Role("UKURAN_C"));}
        if (ukuranR){roles.add(new Role("UKURAN_R"));}
        if (ukuranU){roles.add(new Role("UKURAN_U"));}
        if (ukuranD){roles.add(new Role("UKURAN_D"));}
        if (warnaC){roles.add(new Role("WARNA_C"));}
        if (warnaR){roles.add(new Role("WARNA_R"));}
        if (warnaU){roles.add(new Role("WARNA_U"));}
        if (warnaD){roles.add(new Role("WARNA_D"));}
        if (userC){roles.add(new Role("USER_C"));}
        if (userR){roles.add(new Role("USER_R"));}
        if (userU){roles.add(new Role("USER_U"));}
        if (userD){roles.add(new Role("USER_D"));}
        if (roleGroupC){roles.add(new Role("ROLE_GROUP_C"));}
        if (roleGroupR){roles.add(new Role("ROLE_GROUP_R"));}
        if (roleGroupU){roles.add(new Role("ROLE_GROUP_U"));}
        if (roleGroupD){roles.add(new Role("ROLE_GROUP_D"));}
        if (reportC){roles.add(new Role("REPORT_C"));}
        if (reportR){roles.add(new Role("REPORT_R"));}
        if (reportU){roles.add(new Role("REPORT_U"));}
        if (reportD){roles.add(new Role("REPORT_D"));}

        roleGroup.setRoles(roles);

        return roleGroup;
    }
}
