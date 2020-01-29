package com.rishabh.springboot.databasecontroller;


import javax.persistence.*;

@Entity
@Table(name = "branch_db")
public class BranchDataBase {

    @Id
    String state;
    @Column
    String state_code;
    @Column
    Long minimum_wages;
    @Column
    Long hra_per;

    public String getState() {
        return state;
    }

    public void setState(String STATE) {
        this.state = STATE;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String STATE_CODE) {
        this.state_code = STATE_CODE;
    }

    public Long getMinimum_wages() {
        return minimum_wages;
    }

    public void setMinimum_wages(Long MINIMUM_WAGES) {
        this.minimum_wages = MINIMUM_WAGES;
    }

    public Long getHra_per() {
        return hra_per;
    }

    public void setHra_per(Long HRA_PER) {
        this.hra_per = HRA_PER;
    }
}
