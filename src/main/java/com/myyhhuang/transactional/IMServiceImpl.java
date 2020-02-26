package com.myyhhuang.transactional;

import com.myyhhuang.beanim.IMAPILog;
import com.myyhhuang.beanim.IMCounty;
import com.myyhhuang.constants.DATA_ENTRY_TYPE;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("IMServiceDao")
public class IMServiceImpl extends ServiceBase implements IMServiceDao {
	protected Logger logger = LogManager.getLogger(this.getClass().getName());	
	
	//0.Start
	@Override
	public boolean modifyTableObj(DATA_ENTRY_TYPE data_entry_type, List<Object> tableObjList) {
		Session mySession = getSession();
		Transaction trx= null;
		try {
			trx = mySession.getTransaction();
			trx.begin();
			for (Object object : tableObjList) {
				switch (data_entry_type) {
				case ADD : mySession.save(object);break;
				case MODIFY : mySession.saveOrUpdate(object);break;
				case UPDATE : mySession.update(object);break;
				case DELETE : mySession.delete(object);break;
				default:
					break;
				}
			}
			trx.commit();
			return true;
		} catch (Exception e) {
			logger.error(e);
			if (trx != null)
				trx.rollback();
			return false;
		} finally {
			if (mySession != null && mySession.isOpen() == true)
				mySession.close();
		}
	}

	@Override
	public boolean modifyTable(DATA_ENTRY_TYPE data_entry_type, Object object) {
		Session mySession = getSession();
		Transaction trx= null;
		try {
			trx = mySession.getTransaction();
			trx.begin();
			switch (data_entry_type) {
			case ADD : mySession.save(object);break;
			case MODIFY : mySession.saveOrUpdate(object);break;
			case UPDATE : mySession.update(object);break;
			case DELETE : mySession.delete(object);break;
			default:
				break;
			}
			
			trx.commit();
			return true;
		} catch (Exception e) {
			logger.error(e);
			if (trx != null)
				trx.rollback();
			return false;
		} finally {
			if (mySession != null && mySession.isOpen() == true)
				mySession.close();
		}
	}
	
	//1.IMCounty 發證地點行政區域
	@Override
	@Transactional(readOnly=true)
	public List<IMCounty> retriveIMCounty() {
		Session session = getSession();
		try {
			String sHql = " FROM IMCounty c ORDER BY countyCode ASC";
			TypedQuery<IMCounty> query = session.createQuery(sHql);
			List<IMCounty> imCountyList = query.getResultList();
			return imCountyList;
		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if (session != null && session.isOpen() == true)
				session.close();
		}
	}
	
	//2.IMAPILog 記錄檔
	@Override
	@Transactional(readOnly=true)
	public IMAPILog retriveIMAPILog(int seqno) {
		Session session = getSession();
		try {
			String sHql = " FROM IMAPILog c WHERE seqno = :Seqno";
			TypedQuery<IMAPILog> query = session.createQuery(sHql);
			query.setParameter("Seqno", seqno);
			IMAPILog imAPILog = (IMAPILog) query.getSingleResult();
			
			return imAPILog;
		} catch (Exception e) {
			logger.error(e);
			return null;
		} finally {
			if (session != null && session.isOpen() == true)
				session.close();
		}	
	}
}