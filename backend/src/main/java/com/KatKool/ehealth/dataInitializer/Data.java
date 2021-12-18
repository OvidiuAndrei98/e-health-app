package com.KatKool.ehealth.dataInitializer;

import com.KatKool.ehealth.model.*;
import com.KatKool.ehealth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
public class Data implements CommandLineRunner {
    private final BedRepository bedRepository;
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final RoomRepository roomRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public Data(BedRepository bedRepository, DepartmentRepository departmentRepository, DoctorRepository doctorRepository, NurseRepository nurseRepository, PatientRepository patientRepository, RoomRepository roomRepository) {
        this.bedRepository = bedRepository;
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Department department = new Department("Department1");
        Department department2 = new Department("Department2");
        Department department3 = new Department("Department3");

        departmentRepository.saveAll(List.of(department,department2,department3));

        Room room1 = new Room("Room 1", department);
        Room r2 = new Room("Room 2", department);
        Room r3 = new Room("Room 3", department);
        Room r4 = new Room("Room 4", department);
        Room r5 = new Room("Room 5", department2);
        Room r6 = new Room("Room 6", department3);
        Room r7 = new Room("Room 7", department3);
        Room r8 = new Room("Room 8", department3);
        Room r9 = new Room("Room 9", department3);

        roomRepository.saveAll(List.of(room1,r2,r3,r4,r5,r6,r7,r8,r9));



        Patient p2 = new Patient("Penica Ovidiu Andrei",23,"M","07413333332","Diagnosis","Notes",LocalDate.now());
        Patient p1 = new Patient("Stanescu Madalin Andrei",30,"M","07413333332","Diagnosis","Notes",LocalDate.now());
        patientRepository.save(p2);
        patientRepository.save(p1);

        Bed b1 = new Bed(room1);
        Bed b2 = new Bed(room1);
        Bed b3 = new Bed(room1);
        Bed b4 = new Bed(room1);
        Bed b5 = new Bed(room1);
        Bed b6 = new Bed(room1);
        Bed b7 = new Bed(room1);
        Bed b8 = new Bed(room1);
        Bed b9 = new Bed(room1);
        Bed b10 = new Bed(room1);
        Bed b11 = new Bed(room1);
        Bed b12 = new Bed(r2);
        Bed b13 = new Bed(r2);
        Bed b14 = new Bed(r3);
        Bed b15 = new Bed(r4);
        Bed b16 = new Bed(r5);
        Bed b17 = new Bed(r5);
        Bed b18 = new Bed(r5);
        Bed b19 = new Bed(r5);
        Bed b20 = new Bed(r4);
        Bed b21 = new Bed(r6);
        Bed b22 = new Bed(r7,p1);
        Bed b23= new Bed(r7,p2);

        bedRepository.saveAll(List.of(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23));


        Doctor doctor1 = new Doctor("userDoctor",passwordEncoder.encode("123456"),"Doctor", 30,"M", "12345", LocalDate.now(),department, Set.of(UserRole.ROLE_DOCTOR));
        Doctor d2 = new Doctor("userDoctor2",passwordEncoder.encode("123456"),"MEDIC", 34,"F", "12345", LocalDate.now(),department, Set.of(UserRole.ROLE_DOCTOR));

        doctorRepository.saveAll(List.of(doctor1,d2));

        Nurse n1 = new Nurse("Nurse", 30,"F", "12345", LocalDate.now(),department);
        nurseRepository.save(n1);







    }

}
