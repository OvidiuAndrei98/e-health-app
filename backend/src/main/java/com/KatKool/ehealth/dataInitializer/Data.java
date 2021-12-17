package com.KatKool.ehealth.dataInitializer;

import com.KatKool.ehealth.model.Doctor;
import com.KatKool.ehealth.model.Nurse;
import com.KatKool.ehealth.model.Patient;
import com.KatKool.ehealth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.List;

public class Data implements CommandLineRunner {

    private final BedRepository bedRepository;
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public Data(BedRepository bedRepository, DepartmentRepository departmentRepository,
                DoctorRepository doctorRepository, NurseRepository nurseRepository,
                PatientRepository patientRepository, RoomRepository roomRepository) {
        this.bedRepository = bedRepository;
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Doctor d1 = new Doctor("John Smith", 38, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 1);
        Doctor d2 = new Doctor("John Smith", 33, "F", "86745634634",
                LocalDate.of(2005, 1, 1), 1);
        Doctor d3 = new Doctor("John Smith", 39, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 2);
        Doctor d4 = new Doctor("John Smith", 50, "F", "86745634634",
                LocalDate.of(2005, 1, 1), 2);
        Doctor d5 = new Doctor("John Smith", 42, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 1);

        this.doctorRepository.save(List.of(d1, d2, d3, d4, d5));

        Nurse n1 = new Nurse("Lula Bee", 20, "F", "86745634634",
                LocalDate.of(2005, 1, 1), 1, 1);
        Nurse n2 = new Nurse("Joshua Jo", 19, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 1, 1);
        Nurse n3 = new Nurse("Aloe Vera", 22, "F", "86745634634",
                LocalDate.of(2005, 1, 1), 2, 1);
        Nurse n4 = new Nurse("Ham Ster", 35, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 1, 1);
        Nurse n5 = new Nurse("Bour Guoais", 22, "M", "86745634634",
                LocalDate.of(2005, 1, 1), 1, 1);

        Patient p1 = new Patient("Arthur Scwap", 15, "M", "023456789",
                "A tad stupid", "Will sometimes talk to lemons... and they answer", 1, 1, 1,
                LocalDate.of(2020, 1, 8), 1, 1);
        Patient p2 = new Patient("Buang Along", 20, "M", "0564564564",
                "Dad joke symptoms", "Laughs too much at their own jokes", 2, 1, 1,
                LocalDate.of(2020, 5, 6), 2, 2);
        Patient p3 = new Patient("Applause please", 35, "M", "0213231454",
                "sadist", "If you see this pacient approach you... Run.", 2, 1, 2,
                LocalDate.of(2018, 1, 16), 3, 3);
        Patient p4 = new Patient("Annie Wuwu", 6, "F", "2132123213",
                "Weeb Parents", "Watches too much anime... and what is that eyepatch??", 3, 1, 1,
                LocalDate.of(2010, 2, 8), 4, 4);
        Patient p5 = new Patient("Cruella", 55, "F", "05765747468",
                "Bonkers", "She's only allowed synthetics.", 4, 1, 1,
                LocalDate.of(2021, 1, 1), 5, 5);


    }
}
