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

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.services.WatchService;
import com.valtech.training.restapis.vos.WatchVO;

import jakarta.annotation.PostConstruct;

@RestController
public class WatchController {
	
	@Autowired
	private WatchService watchService;
	
	
	
//	@GetMapping("/watches/{brand}")
//	public List<WatchVO> getWatchByBrand(@PathVariable("brand") String brand){
//		return watchService.getWatchesByBrand(brand);
//	}
	
	@GetMapping("/watches/{id}")
	public WatchVO getWatch(@PathVariable("id") long id) {
		return watchService.getWatch(id);
		
	}
	
	@GetMapping("/watches/")
	public List<WatchVO> getWatches(@RequestParam(name="brand",required= false) String brand) {
		if(brand==null)
		return watchService.getWatches();
		else
			return watchService.getWatchesByBrand(brand);
	}
	
	@PostMapping("/watches/")
	public WatchVO createWatch(@RequestBody WatchVO watch) {
		return watchService.createWatch(watch);
		
	}
	
	@PutMapping("/watches/{id}")
	public WatchVO updateWatch(@PathVariable("id")long id, @RequestBody WatchVO watch) {
		return watchService.updateWatch(id, watch);
		
	}

}
