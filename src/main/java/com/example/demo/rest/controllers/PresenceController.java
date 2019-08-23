package com.example.demo.rest.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Presence;
import com.example.demo.rest.dto.PresenceDto;
import com.example.demo.services.EmployeService;
import com.example.demo.services.PresenceService;

@CrossOrigin("*")
@RestController()
public class PresenceController {
	
	
	@Autowired
	private PresenceService presenceService ;
	
	@Autowired
    private EmployeService employeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	  @PostMapping("/Employee/{idEmploye}/Presences")
	    public Object addPresenceEmployee(@PathVariable("idEmploye") Long idEmploye, @Valid @RequestBody PresenceDto presenceDto) {
	        Employee employee = employeService.getEmployee(idEmploye);
	        Presence presence = modelMapper.map(presenceDto, Presence.class);
	        presence = presenceService.savePresenceEmploye(presence, employee);
	        presenceDto = modelMapper.map(presence, PresenceDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(presenceDto);
	    }
	
	 @GetMapping("/Employee/{idEmploye}/Presences")
	    public Object PresencesEmployeeList(@PathVariable("idEmploye") Long idEmploye) {
	        List<Presence> presences = presenceService.getPresenceEmploye(idEmploye);
	        Type listType = new TypeToken<List<PresenceDto>>() {
	        }.getType();
	        List<PresenceDto> presenceDtos = modelMapper.map(presences, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(presenceDtos);
	    }
	
	@PutMapping("/Employee/{idEmploye}/Presences/{id}")
  public Object updatePresenceEmployee(@Valid @RequestBody PresenceDto presenceDto, @PathVariable("id") Long id, @PathVariable("idEmploye") Long idEmploye) {
      Employee employee = employeService.getEmployee(idEmploye);
      Presence presence = modelMapper.map(presenceDto, Presence.class);
      presence = presenceService.updatePresenceEmploye(id, presence, employee);
      presenceDto = modelMapper.map(presence, PresenceDto.class);
      return ResponseEntity.status(HttpStatus.CREATED).body(presenceDto);
  }
	
	
	@DeleteMapping("/supPresencerPresence/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		presenceService.deletePresence(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
