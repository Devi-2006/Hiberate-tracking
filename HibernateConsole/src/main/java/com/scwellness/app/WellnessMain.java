package com.scwellness.app;

import java.sql.Date;

import com.scwellness.bean.Program;
import com.scwellness.bean.Senior;
import com.scwellness.service.WellnessService;

public class WellnessMain {

    public static void main(String[] args) {

        WellnessService service = new WellnessService();
        Senior senior = new Senior();
        senior.setSeniorID("SR3002");
        senior.setFullName("Meenakshi Devi");
        senior.setAge(72);
        senior.setGender("FEMALE");
        senior.setChronicConditions("Hypertension");
        senior.setPrimaryPhone("9887766554");
        senior.setEmergencyContactName("Ravi Kumar");
        senior.setEmergencyContactPhone("9001122334");

        String seniorResult = service.registerNewSenior(senior);
        System.out.println("Register Senior Result: " + seniorResult);

        Program program = new Program();
        program.setProgramID("PRGHT20");
        program.setProgramName("Heart Wellness Program");
        program.setCategory("CARDIAC_CARE");
        program.setRecommendedDurationWeeks(12);
        program.setSessionFrequency("Twice a Week");

        String programResult = service.createProgram(program);
        System.out.println("Create Program Result: " + programResult);

        Date sessionDate = Date.valueOf("2026-04-15");

        String sessionResult = service.scheduleSession(
                "SR3002",
                "PRGHT20",
                sessionDate,
                "10:00-10:30",
                "Dr. Anitha Sharma"
        );

        System.out.println("Schedule Session Result: " + sessionResult);
    }
}