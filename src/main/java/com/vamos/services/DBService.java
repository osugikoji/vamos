package com.vamos.services;

import com.vamos.domain.*;
import com.vamos.domain.enums.DayEnum;
import com.vamos.domain.enums.PaymentStatusEnum;
import com.vamos.domain.enums.ShiftEnum;
import com.vamos.domain.enums.UserProfileEnum;
import com.vamos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private InstitutionRepository institutionRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;
	
	public void instantiateDataBase() throws ParseException {
		
		State state1 = new State(null,"SP");
		State state2 = new State(null,"MG");
		
		City city1 = new City(null,"Campinas", state1);
		City city2 = new City(null,"Indaiatuba", state1);
		City city3 = new City(null,"Divinopolis", state2);
		City city4 = new City(null,"Belo Horizonte", state2);
		
		state1.getCities().addAll(Arrays.asList(city1, city2));
		state2.getCities().addAll(Arrays.asList(city3, city4));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3, city4));
		
		Institution institution1 = new Institution(null, "PUC-Campinas");
		Institution institution2 = new Institution(null, "Mackenzie");
		institutionRepository.saveAll(Arrays.asList(institution1, institution2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Driver driver1 = new Driver(null, "José da Silva", "jose@gmail.com", bCryptPasswordEncoder.encode("1234"), sdf.parse("08/03/1965"), "01838955682", "12597" );
		driver1.getPhones().addAll(Arrays.asList("1998652354","1933245698"));
		Driver driver2 = new Driver(null, "Claudio Oliveira", "claudio@gmail.com", bCryptPasswordEncoder.encode("1234"), sdf.parse("08/03/1975"), "01838955682", "12597" );
		driver2.getPhones().addAll(Arrays.asList("1996572345","1996357412"));
		driverRepository.saveAll(Arrays.asList(driver1, driver2));
		
		VanGroup vanGroup1 = new VanGroup(null, "VanGroup do Jose Noturno", 15, institution1, ShiftEnum.NIGHT, driver1);
		VanGroup vanGroup2 = new VanGroup(null, "VanGroup do Jose Matutino", 15, institution2, ShiftEnum.MORNING, driver1);
		VanGroup vanGroup3 = new VanGroup(null, "VanGroup do Claudio", 15, institution2, ShiftEnum.AFTERNOON, driver2);
		groupRepository.saveAll(Arrays.asList(vanGroup1, vanGroup2, vanGroup3));
		
		Student student1 = new Student(null, "Koji Osugi", "koji097@gmail.com", bCryptPasswordEncoder.encode("1234"), sdf.parse("08/03/1997"), institution1, PaymentStatusEnum.PENDING);
		student1.getPhones().addAll(Arrays.asList("19982252031","1933297165"));
		Student student2 = new Student(null, "Joao Zullo", "zullo@gmail.com", bCryptPasswordEncoder.encode("1234"), sdf.parse("08/03/1995"), institution2, PaymentStatusEnum.PAID);
		student2.getPhones().addAll(Arrays.asList("37334456989","3798562456"));
		studentRepository.saveAll(Arrays.asList(student1, student2));

		List<DailySchedule> dailySchedule1 = createDias(student1);
		dailyScheduleRepository.saveAll(dailySchedule1);
		student1.setDailySchedules(dailySchedule1);
		studentRepository.saveAll(Arrays.asList(student1));

		student1.getGroups().addAll(Arrays.asList(vanGroup1));
		student2.getGroups().addAll(Arrays.asList(vanGroup2));

		vanGroup1.getStudents().addAll(Arrays.asList(student1));
		vanGroup2.getStudents().addAll(Arrays.asList(student2));

		studentRepository.saveAll(Arrays.asList(student1, student2));
		groupRepository.saveAll(Arrays.asList(vanGroup1, vanGroup2));

		Address address1 = new Address(null, "Rua Jose Bernardinetti", "180", null, "Jardim Recanto do Valle", city2, student1);
		Address address2 = new Address(null, "Rua Itaperuna", "801", null, "Icarai", city3, student2);
		addressRepository.saveAll(Arrays.asList(address1, address2));
	}

	private List<DailySchedule> createDias(Student student){
		List<DailySchedule> list = new ArrayList<>();
		DailySchedule segunda = new DailySchedule(null, DayEnum.MONDAY, true, true, student);
		DailySchedule terca = new DailySchedule(null, DayEnum.TUESDAY, true, true, student);
		DailySchedule quarta = new DailySchedule(null, DayEnum.WEDNESDAY, true, true, student);
		DailySchedule quinta = new DailySchedule(null, DayEnum.THURSDAY, true, true, student);
		DailySchedule sexta = new DailySchedule(null, DayEnum.FRIDAY, true, true, student);
		DailySchedule sabado = new DailySchedule(null, DayEnum.SATURDAY, false, false, student);
		DailySchedule domingo = new DailySchedule(null, DayEnum.SUNDAY, false, false, student);
		list.addAll(Arrays.asList(segunda,terca,quarta,quinta,sexta,sabado,domingo));
		return list;
	}

}
