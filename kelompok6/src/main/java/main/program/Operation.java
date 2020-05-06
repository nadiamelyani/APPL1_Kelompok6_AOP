package main.program;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import model.Pelajaran;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class Operation {
	private MongoOperations mongoOperations;
	private static final String COLLECTION = "Pelajaran";
	
	public Operation(MongoOperations mongoOperations){
		this.mongoOperations = mongoOperations;
	}
	
	public void create(Pelajaran p) {
		this.mongoOperations.insert(p, COLLECTION);
	}

	public Pelajaran readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOperations.findOne(query, Pelajaran.class, COLLECTION);
	}

	public void update(Pelajaran p) {
		this.mongoOperations.save(p, COLLECTION);
	}

	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOperations.remove(query, Pelajaran.class, COLLECTION);
		return result.getN();
	}
	
	public ArrayList<Pelajaran> getPelajaran() throws IOException {		
		ArrayList<Pelajaran> resultList = new ArrayList();
		DBCollection collection = this.mongoOperations.getCollection(COLLECTION);
		DBCursor pelajaranIter = collection.find();
		while(pelajaranIter.hasNext()) {
			System.out.println(pelajaranIter.next());
			resultList.add((Pelajaran) pelajaranIter.next());
		}		
		return resultList;
	}
}


