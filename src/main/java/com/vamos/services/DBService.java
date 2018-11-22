package com.vamos.services;

import com.vamos.domain.*;
import com.vamos.domain.enums.DayEnum;
import com.vamos.domain.enums.PaymentStatusEnum;
import com.vamos.domain.enums.ShiftEnum;
import com.vamos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {
	
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
	private PassengerRepository passengerRepository;
	@Autowired
	private WeeklyScheduleRepository weeklyScheduleRepository;
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
		
		Driver driver1 = new Driver(null, "José da Silva", "jose@gmail.com", "123", sdf.parse("08/03/1965"), "01838955682", "12597" );
		driver1.getPhones().addAll(Arrays.asList("1998652354","1933245698"));
		Driver driver2 = new Driver(null, "Claudio Oliveira", "claudio@gmail.com", "123", sdf.parse("08/03/1975"), "01838955682", "12597" );
		driver2.getPhones().addAll(Arrays.asList("1996572345","1996357412"));
		driverRepository.saveAll(Arrays.asList(driver1, driver2));
		
		VanGroup vanGroup1 = new VanGroup(null, "VanGroup do Jose Noturno", 15, institution1, ShiftEnum.NIGHT, driver1);
		VanGroup vanGroup2 = new VanGroup(null, "VanGroup do Jose Matutino", 15, institution2, ShiftEnum.MORNING, driver1);
		VanGroup vanGroup3 = new VanGroup(null, "VanGroup do Claudio", 15, institution2, ShiftEnum.AFTERNOON, driver2);
		groupRepository.saveAll(Arrays.asList(vanGroup1, vanGroup2, vanGroup3));
		
		Student student1 = new Student(null, "Koji Osugi", "koji097@gmail.com", "1234", sdf.parse("08/03/1997"), institution1);
		student1.getPhones().addAll(Arrays.asList("19982252031","1933297165"));
		Student student2 = new Student(null, "Joao Zullo", "zullo@gmail.com", "1234", sdf.parse("08/03/1995"), institution2);
		student2.getPhones().addAll(Arrays.asList("37334456989","3798562456"));
		studentRepository.saveAll(Arrays.asList(student1, student2));

		WeeklySchedule weeklySchedule = new WeeklySchedule();
		WeeklySchedule weeklySchedule2 = new WeeklySchedule();
		List<StatusDay> statusDias1 = this.createDias(weeklySchedule);
		List<StatusDay> statusDias2 = this.createDias(weeklySchedule2);
		weeklySchedule.getStatusDays().addAll(statusDias1);
		weeklySchedule2.getStatusDays().addAll(statusDias2);
		weeklyScheduleRepository.saveAll(Arrays.asList(weeklySchedule, weeklySchedule2));
		dailyScheduleRepository.saveAll(statusDias1);
		dailyScheduleRepository.saveAll(statusDias2);

		Passenger integrante1 = new Passenger(student1, vanGroup1, PaymentStatusEnum.PAID, weeklySchedule);
		Passenger integrante2 = new Passenger(student1, vanGroup2, PaymentStatusEnum.PENDING, weeklySchedule2);
		passengerRepository.saveAll(Arrays.asList(integrante1,integrante2));

		student1.getGroups().addAll(Arrays.asList(integrante1));
		student2.getGroups().addAll(Arrays.asList(integrante2));

		vanGroup1.getPassengers().addAll(Arrays.asList(integrante1));
		vanGroup2.getPassengers().addAll(Arrays.asList(integrante2));

		studentRepository.saveAll(Arrays.asList(student1, student2));
		groupRepository.saveAll(Arrays.asList(vanGroup1, vanGroup2));

		Address address1 = new Address(null, "Rua Jose Bernardinetti", "180", null, "Jardim Recanto do Valle", city2, student1);
		Address address2 = new Address(null, "Rua Itaperuna", "801", null, "Icarai", city3, student2);
		addressRepository.saveAll(Arrays.asList(address1, address2));
	}

	private List<StatusDay> createDias(WeeklySchedule weeklySchedule){
		List<StatusDay> list = new ArrayList<>();
		StatusDay segunda = new StatusDay(null, DayEnum.MONDAY, true, true, weeklySchedule);
		StatusDay terca = new StatusDay(null, DayEnum.TUESDAY, true, true, weeklySchedule);
		StatusDay quarta = new StatusDay(null, DayEnum.WEDNESDAY, true, true, weeklySchedule);
		StatusDay quinta = new StatusDay(null, DayEnum.THURSDAY, true, true, weeklySchedule);
		StatusDay sexta = new StatusDay(null, DayEnum.FRIDAY, true, true, weeklySchedule);
		StatusDay sabado = new StatusDay(null, DayEnum.SATURDAY, false, false, weeklySchedule);
		StatusDay domingo = new StatusDay(null, DayEnum.SUNDAY, false, false, weeklySchedule);
		list.addAll(Arrays.asList(segunda,terca,quarta,quinta,sexta,sabado,domingo));
		return list;
	}

}
