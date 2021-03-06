package com.rishabh.springboot.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class DomainTest {

    Domain d = new Domain();

    @BeforeEach
    void setUp() {


    }

    @Test
    void basic_ctc() {

//        Domain d = new Domain();
        Long val = d.basic_ctc(15509L,9171L);
        assertEquals(9171,val);

    }

    @Test
    void basic_ctc_exception_case() {


        try {
            Long val = d.basic_ctc((15509L) / 0, (9171L) / 0);
            assertEquals(9171, val);
        } catch (ArithmeticException e) {
            System.out.println("/ by zero ArithmeticException");
            e.printStackTrace();

        }
    }

    @Test
    void bonus_ctc() {

        Long val = d.bonus_ctc(9171L);
        assertEquals(764,val);
    }

    @Test
    void bonus_ctc_exception() {

        try {


            Long val = d.bonus_ctc(Long.valueOf(null));
            assertEquals( 0,val,"Should give an NumberFormatExcception");

        }catch (NumberFormatException e1)
        {
            System.out.println("NumberFormatException");
            System.out.println(e1);
        }
    }

    @Test
    void employer_pf_contribution() {

        Long val = d.employer_pf_contribution(9171L);
        assertEquals(1100,val);
    }

    @Test
    void employer_pf_contribution_exception() {

        try {


            Long val = d.employer_pf_contribution(Long.valueOf(null));
            assertEquals( 0,val,"Should give an NumberFormatExcception");

        }catch (NumberFormatException e1)
        {
            System.out.println("NumberFormatException");
            System.out.println(e1);
        }
    }


    @Test
    void gratuity_from_ctc() {

        Long val = d.gratuity_from_ctc(9171L);
        assertEquals(441,val);
    }

    @Test
    void gratuity_from_ctc_exception()
    {
        try{



            Long val = d.gratuity_from_ctc(9171L/0);
            assertEquals(764,val);
            //fail("should have thrown an Exception");
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }
    }


    @Test
    void gross_total() {

        Long val = d.gross_total(15509L,1100L,441L);
        assertEquals(13335,val);

    }

    @Test
    void gross_total_exception()
    {
        try{

            Long val = d.gross_total(15509L/0,1100L,441L);
            assertEquals(13335,val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }

    }


    @Test
    void employer_esi_contribution() {
        Long val = d.employee_esi_contribution(13335L);                   //check
        assertEquals(233,val);
    }

    @Test

    void employer_esi_contribution_Exception() {

        try {

            Long val = d.employee_esi_contribution(13335L/ 0);      //check
            assertEquals(233, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }
    }



    @Test
    void employee_pf_contribution() {

        Long val = d.employee_pf_contribution(9171L);
        assertEquals(1100,val);

    }



    @Test
    void employee_pf_contribution_exception() {

        try {


            Long val = d.employee_pf_contribution(Long.valueOf(null));
            assertEquals( 0,val,"Should give an NumberFormatExcception");

        }catch (NumberFormatException e1)
        {
            System.out.println("NumberFormatException");
            System.out.println(e1);
        }
    }
    @Test
    void employee_esi_contribution() {

        Long val = d.employee_esi_contribution(13335L);
        assertEquals(233,val);
    }

    @Test
    void employee_esi_contribution_exception()
    {
        try {

            Long val = d.employee_esi_contribution(13335L/ 0);
            assertEquals(233, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }


    }


    @Test
    void netpay() {

        Long val = d.netpay(13335L,1100L,233L);
        assertEquals(12002, val);
    }

    @Test
    void netpay_Exception() {

        try {

            Long val = d.netpay(13335L/0, 1100L/0,233L/0);
            assertEquals(12002L, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }
    }


    @Test
    void homerentallowance() {

        Long val = d.homerentallowance(9171L,764L,1334L,12002L,50L);
        assertEquals(3401, val);
    }


    @Test
    void homerentallowance_Exception() {

        try {

            Long val = d.homerentallowance(9171L/0, 764L, 1334L, 12002L,50L);
            assertEquals(3401, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }
    }
    @Test
    void grossDed() {

        Long val = d.grossDed(1100L,233L);
        assertEquals(1333,val);
    }

    @Test
    void grossDed_Exception() {

        try {

            Long val = d.grossDed(1100L/0, 233L/0);
            assertEquals(1333, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();

        }
    }

    @Test
    void nettakehome() {

        Long val = d.nettakehome(13335L,1334L);
        assertEquals(12001,val);
    }

    @Test
    void nettakehome_Exception() {

        try {

            Long val = d.nettakehome(13335L/0, 1334L/0);
            assertEquals(12001, val);
        }
        catch (ArithmeticException e)
        {
            System.out.println("/ by 0 ArithmeticExceion");
            e.printStackTrace();
        }
    }

    @Test
    void difference() {

        Long val = d.difference(12002L,12002L);
        assertEquals(0,val);
    }

    @Test
    void ptgross() {

        Long val = d.ptgross(12002L,1334L);
        assertEquals(13336,val);
    }
}