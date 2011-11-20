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
import com.fusion.model.core.Criteria;
import com.fusion.model.core.Criterias;
import com.fusion.model.core.Parties;
import com.fusion.model.core.Party;
import com.fusion.model.core.Status;
import com.fusion.model.core.User;
import com.fusion.model.instance.AllConfirmCriteria;
import com.fusion.model.instance.AllConfirmFact;
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
		db.getCollection("User").drop();
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
		
		Datastore mdb=new Morphia().map(Activity.class).createDatastore(mongo, "fusion");
		mdb.ensureIndexes();

		Activity act=new Activity();
		act.setTitle("My first activity");
		act.setMemo("搭顺风车万科魅力");
		act.setStatus(Status.pending);
		
//		mdb.save(act);
//		act=mdb.find(Activity.class).get();
		
		Parties parties=new Parties();
		User user=new User();
		user.setUid("zhangkevin");
		user.setCredit(null);
		user.setNickName("kevin zhang");
		user.setPoints(102);
		user.setRegisterDate(new Date());
		User user2=new User();
		user2.setUid("jiangjason");
		user2.setCredit(null);
		user2.setNickName("jiang shuai");
		user2.setPoints(107);
		ArrayList<Party> partyList=new ArrayList<Party>();
		Party party1=new Party(user);
		Party party2=new Party(user2);
		partyList.add(party1);
		partyList.add(party2);
		parties.setParties(partyList);
		
		//act.setCreator(user);
		act.setParties(parties);
		
		Criterias criterias=new Criterias();
		Criteria criteria=new AllConfirmCriteria();
		criteria.setActivity(act);
		AllConfirmFact fact= (AllConfirmFact)criteria.getFact();
		fact.confirm(party1);
		fact.confirm(party2);
		//fact.takeBack(party2);
		criterias.addCriteria(criteria);
		act.setCriterias(criterias);
		assertTrue(act.getCriterias().isMet()); 

		
		mdb.save(user);
		mdb.save(user2);
		
		mdb.save(act);
		
		Activity dbact=mdb.find(Activity.class).get();
		assertEquals(2, dbact.getParties().getParties().size());
		//assertTrue(dbact.getCriterias().isMet());
		
		
		
	}

}
