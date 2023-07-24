package com.fullstack.restAPI.mongodb;

import java.io.IOException;


import com.fullstack.restAPI.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.restAPI.bankdata.*;
@RestController
@RequestMapping("/api")
public class MongoController {

	@Autowired
	private ModelMongoRepository mongoRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(path="/repo", method = RequestMethod.GET)
	public Iterable<Model> findByRepo() throws IOException {
		return mongoRepository.findAll();
	}
	
	@RequestMapping(path="/template", method = RequestMethod.GET)
	public Iterable<Model> findByTemplate() throws IOException {
		return mongoTemplate.findAll(Model.class);
	}

	@RequestMapping(value = "/repo/{value}", method = RequestMethod.GET)
	public void saveByRepo(@PathVariable String value) {
		Model model = new Model();
		model.setId(System.currentTimeMillis());
		model.setValue(value);
		mongoRepository.save(model);
	}
	
	@RequestMapping(value = "/template/{value}", method = RequestMethod.GET)
	public void saveByTemplate(@PathVariable String value) {
		Model model = new Model();
		model.setId(System.currentTimeMillis());
		model.setValue(value);
		mongoTemplate.save(model);
	}


	@RequestMapping(path="/hashtable", method = RequestMethod.GET)
	public Iterable<DataModel> findHashtableByTemplate() throws IOException {
		return mongoTemplate.findAll(DataModel.class);
	}


	@RequestMapping(value = "/hashtable/add/{value}", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> saveHashtable(@PathVariable String value) {
		ResponseMessage result=new ResponseMessage();

		 try {
			 DataModel dataModel = new DataModel();
			 dataModel.setId(System.currentTimeMillis());

			 mongoTemplate.save(dataModel);
		 }
		 catch(Exception e)
		 {
			 result.setMessage("error");
			 result.setErrorReason(e.getMessage());
		 }
		return ResponseEntity.ok(result);
	}


	@RequestMapping(value = "/lookup/add", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> addLookup() {
		ResponseMessage result=new ResponseMessage();

		try {
			DataModel dataModel = new DataModel();
			dataModel.initLookup();
			dataModel.setId(System.currentTimeMillis());
			mongoTemplate.save(dataModel);
		}
		catch(Exception e)
		{
			result.setMessage("error");
			result.setErrorReason(e.getMessage());
		}
		return ResponseEntity.ok(result);
	}


	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> addUser() {
		ResponseMessage result=new ResponseMessage();

		try {

			User user=new User();
			user.initData();
			user.setId(System.currentTimeMillis());
			mongoTemplate.save(user);
		}
		catch(Exception e)
		{
			result.setMessage("error");
			result.setErrorReason(e.getMessage());
		}
		return ResponseEntity.ok(result);
	}


	@RequestMapping(value = "/hashtable/last", method = RequestMethod.GET)
	public DataModel fetchLastHashtable() {
		long count=mongoTemplate.
				findAll(DataModel.class).
				stream().
				count();
		DataModel last= mongoTemplate.
				findAll(DataModel.class).
				stream().
				skip(count-1).
				findFirst().
				get();
		return last;
	}




	@RequestMapping(value = "/lookup/last", method = RequestMethod.GET)
	public DataModel fetchLastLookupTable() {

		DataModel last= mongoTemplate.
				findAll(DataModel.class)
				.stream()
				.reduce((first, second) -> second)
				.orElse(null);
		return last;
	}

	@RequestMapping(value = "/user/last", method = RequestMethod.GET)
	public User fetchLastUser() {

		User last= mongoTemplate.
				findAll(User.class)
				.stream()
				.reduce((first, second) -> second)
				.orElse(null);
		return last;
	}
}
