package com.fullstack.restAPI.mongodb;

import java.io.IOException;
import java.util.Hashtable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.databind.ObjectMapper;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataModel {
	
	@Id
	private long id;
	
	private Hashtable<Integer, String[]> data;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hashtable<Integer, String[]> getData() {
		return data;
	}

	public void setData(Hashtable<Integer, String[]> value) {
		this.data = value;
	}

    public DataModel()
	{
		Hashtable<Integer, String[]> map = new Hashtable<Integer, String[]>() {
		};
		String[] eqArray={"I","II"};
		map.put((int)(System.currentTimeMillis()/1000), eqArray);


		this.data=map;
	}


	public void initLookup() throws IOException
	{

		Hashtable<Integer, String[]> table=new Hashtable<Integer, String[]>();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "{\"1\": [\"\", \"I\", \"II\", \"III\", \"IV\", \"V\", \"VI\", \"VII\", \"VIII\", \"IX\"]," +
				"\"2\": [\"\", \"X\", \"XX\", \"XXX\", \"XL\", \"L\", \"LX\", \"LXX\", \"LXXX\", \"XC\"]," +
				"\"3\": [\"\", \"C\", \"CC\", \"CCC\", \"CD\", \"D\", \"DC\", \"DCC\", \"DCCC\", \"CM\"]," +
				" \"4\": [\"\", \"M\", \"MM\", \"MMM\"]"+
				"}";
		table = objectMapper.readValue(jsonString,
				objectMapper.getTypeFactory().constructMapLikeType(
						Hashtable.class, Integer.class, String[].class)
		);

		this.data=table;
	}

}
