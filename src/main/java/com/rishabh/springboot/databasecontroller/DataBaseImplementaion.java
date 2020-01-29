package com.rishabh.springboot.databasecontroller;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;




@Repository
@Entity

@Table(name = "employee_data")

public class DataBaseImplementaion {


    @Id
    private String ecode;

    @Column
    private String ename;
    @Column
    private String loc;
    @Column
    private String state;
    @Column
    private Long hra;
    @Column
    private Long net_take_home;
    @Column
    private Long ctc;
    @Column
    private Long basic;
    @Column
    private Long bonus;
    @Column
    private Long spll;
    @Column
    private Long employer_pf;
    @Column
    private Long employer_esi;
    @Column
    private Long gratuity;
    @Column
    private Long gross;
    @Column
    private Long employee_Pf;
    @Column
    private Long employee_esi;
    @Column
    private Long employee_pt;
    @Column
    private Long employee_lwf;
    @Column
    private Long gross_ded;
    @Column
    private Long diff;
    @Column
    private Long pt_gross;
    @Column
    private Long net_Pay;


    // Getter ans setter

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ECODE) {
        this.ecode = ECODE;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ENAME) {
        this.ename = ENAME;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String LOC) {
        this.loc = LOC;
    }

    public String getState() {
        return state;
    }

    public void setState(String STATE) {
        this.state = STATE;
    }

    public Long getHra() {
        return hra;
    }

    public void setHra(Long HRA) {
        this.hra = HRA;
    }

    public Long getNet_take_home() {
        return net_take_home;
    }

    public void setNet_take_home(Long NET_TAKE_HOME) {
        this.net_take_home = NET_TAKE_HOME;
    }

    public Long getCtc() {
        return ctc;
    }

    public void setCtc(Long CTC) {
        this.ctc = CTC;
    }

    public Long getBasic() {
        return basic;
    }

    public void setBasic(Long BASIC) {
        this.basic = BASIC;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long BONUS) {
        this.bonus = BONUS;
    }

    public Long getSpll() {
        return spll;
    }

    public void setSpll(Long SPLL) {
        this.spll = SPLL;
    }

    public Long getEmployer_pf() {
        return employer_pf;
    }

    public void setEmployer_pf(Long EMPLOYER_PF) {
        this.employer_pf = EMPLOYER_PF;
    }

    public Long getEmployer_esi() {
        return employer_esi;
    }

    public void setEmployer_esi(Long EMPLOYER_ESI) {
        this.employer_esi = EMPLOYER_ESI;
    }

    public Long getGratuity() {
        return gratuity;
    }

    public void setGratuity(Long GRATUITY) {
        this.gratuity = GRATUITY;
    }

    public Long getGross() {
        return gross;
    }

    public void setGross(Long GROSS) {
        this.gross = GROSS;
    }

    public Long getEmployee_Pf() {
        return employee_Pf;
    }

    public void setEmployee_Pf(Long EMPLOYEE_PF) {
        this.employee_Pf = EMPLOYEE_PF;
    }

    public Long getEmployee_esi() {
        return employee_esi;
    }

    public void setEmployee_esi(Long EMPLOYEE_ESI) {
        this.employee_esi = EMPLOYEE_ESI;
    }

    public Long getEmployee_pt() {
        return employee_pt;
    }

    public void setEmployee_pt(Long EMPLOYEE_PT) {
        this.employee_pt = EMPLOYEE_PT;
    }

    public Long getEmployee_lwf() {
        return employee_lwf;
    }

    public void setEmployee_lwf(Long EMPLOYEE_LWF) {
        this.employee_lwf = EMPLOYEE_LWF;
    }

    public Long getGross_ded() {
        return gross_ded;
    }

    public void setGross_ded(Long GROSS_DED) {
        this.gross_ded = GROSS_DED;
    }

    public Long getDiff() {
        return diff;
    }

    public void setDiff(Long DIFF) {
        this.diff = DIFF;
    }

    public Long getPt_gross() {
        return pt_gross;
    }

    public void setPt_gross(Long PT_GROSS) {
        this.pt_gross = PT_GROSS;
    }

    public Long getNet_Pay() {
        return net_Pay;
    }

    public void setNet_Pay(Long NET_PAY) {
        this.net_Pay = NET_PAY;
    }


    public DataBaseImplementaion() {
    }

    public DataBaseImplementaion(String ecode, String ename) {
        this.ecode = ecode;
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "DataBaseImplementaion{" +
                "ecode='" + ecode + '\'' +
                ", ename='" + ename + '\'' +
                ", loc='" + loc + '\'' +
                ", state='" + state + '\'' +
                ", hra=" + hra +
                ", net_take_home=" + net_take_home +
                ", ctc=" + ctc +
                ", basic=" + basic +
                ", bonus=" + bonus +
                ", spll=" + spll +
                ", employer_pf=" + employer_pf +
                ", employer_esi=" + employer_esi +
                ", gratuity=" + gratuity +
                ", gross=" + gross +
                ", employee_Pf=" + employee_Pf +
                ", employee_esi=" + employee_esi +
                ", employee_pt=" + employee_pt +
                ", employee_lwf=" + employee_lwf +
                ", gross_ded=" + gross_ded +
                ", diff=" + diff +
                ", pt_gross=" + pt_gross +
                ", net_Pay=" + net_Pay +
                '}';
    }
}
