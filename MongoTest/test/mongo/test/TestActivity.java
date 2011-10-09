/**
 * 
 */
package mongo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fusion.core.model.Activity;
import com.fusion.core.model.Parties;
import com.fusion.core.model.Party;
import com.fusion.core.model.Status;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author zhijun
 *
 */
@SuppressWarnings("unused")
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
		act.setMemo("No need to say more about it");
		act.setStatus(Status.open);
		
		Parties parties=new Parties();
		Party party=new Party();
		party.setCredit(null);
		party.setNickName("kevin zhang");
		party.setPoints(102);
		Party party2=new Party();
		party2.setCredit(null);
		party2.setNickName("jiang shuai");
		party2.setPoints(107);
		ArrayList<Party> partyList=new ArrayList<Party>();
		partyList.add(party);
		partyList.add(party2);
		parties.setParticipants(partyList);
		
		act.setParties(parties);
		
		Datastore mdb=new Morphia().map(Activity.class).createDatastore(mongo, "fusion");
		mdb.ensureIndexes();
		mdb.save(act);
	}

}
