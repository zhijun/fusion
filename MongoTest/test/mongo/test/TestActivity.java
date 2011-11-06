/**
 * 
 */
package mongo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fusion.model.core.Activity;
import com.fusion.model.core.Parties;
import com.fusion.model.core.Party;
import com.fusion.model.core.Status;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author zhijun
 *
 */
public class TestActivity {
	Mongo mongo;
	DB db;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mongo=new Mongo();
		db=mongo.getDB("fusion");
		db.getCollection("Activity").drop();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mongo.close();
	}

	@Test
	public void test() {
		Activity act=new Activity();
		act.setTitle("My first activity");
		act.setMemo("搭顺风车万科魅力");
		act.setStatus(Status.pending);
		
		Parties parties=new Parties();
		Party party=new Party();
		party.setCredit(null);
		party.setNickName("kevin zhang");
		party.setPoints(102);
		party.setRegisterDate(new Date());
		Party party2=new Party();
		party2.setCredit(null);
		party2.setNickName("jiang shuai");
		party2.setPoints(107);
		ArrayList<Party> partyList=new ArrayList<Party>();
		partyList.add(party);
		partyList.add(party2);
		parties.setParties(partyList);
		
		act.setCreator(party);
		act.setParties(parties);
		
		Datastore mdb=new Morphia().map(Activity.class).createDatastore(mongo, "fusion");
		mdb.ensureIndexes();
		mdb.save(act);
		
		Activity dbact=mdb.find(Activity.class).get();
		assertEquals(2, dbact.getParties().getParties().size());
		
		
		
	}

}
