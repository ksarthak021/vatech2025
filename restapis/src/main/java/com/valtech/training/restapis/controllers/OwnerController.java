package com.valtech.training.restapis.controllers;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.valtech.training.restapis.services.OwnerService;
import com.valtech.training.restapis.vos.OwnerVO;
@RestController
public class OwnerController {
 
	@Autowired
	private OwnerService ownerService;
	
	@PutMapping("/owners/{id}/watches")
	public OwnerVO updateWatches(@PathVariable("id") long id,@RequestBody List<Long>watches) {
		return ownerService.addWatchesToOwner(id,watches);
		
	}
	
	@GetMapping("/owners/{id}")
	public OwnerVO getOwner(@PathVariable("id") long id) {
		return ownerService.getOwner(id);
	}
	
	@GetMapping("/owners/")
	public List<OwnerVO> getOwners(@RequestParam(name="name",required = false) String name) {
		if(name == null)
			return ownerService.getOwners();
		else
			return ownerService.getOwnersByName(name);
	}
	
	@PostMapping("/owners/")
	public OwnerVO createOwner(@RequestBody OwnerVO owner) {
		return ownerService.createOwner(owner);
	}
 
	@PutMapping("/owners/{id}")
	public OwnerVO updateOwner(@PathVariable("id") long id, @RequestBody OwnerVO owner) {
		return ownerService.updateOwner(id, owner);
	}
}
 
 