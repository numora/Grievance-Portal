package com.grievance.web.healthcare.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grievance.web.healthcare.newmodel.Address;
import com.grievance.web.healthcare.newmodel.Grievance;
import com.grievance.web.healthcare.newmodel.Member;
import com.grievance.web.healthcare.newmodel.User;
import com.grievance.web.healthcare.viewbean.GrievanceVB;

@Component
@Repository("grievanceService")
public class GrievanceServiceImpl extends HibernateDaoSupport implements
		GrievanceService {

	@Override
	@Transactional
	public boolean createGrievance(Grievance grievance) {
		boolean status = false;
		try {
			// Member Info
			Address memberaddress = grievance.getMember().getAddress();
			getHibernateTemplate().save(memberaddress);
			Member member = grievance.getMember();
			member.setAddress_id(memberaddress.getAddress_id());
			getHibernateTemplate().save(member);
			grievance.setMember_id(member.getMember_id());

			// FedMember Info
			Address fedmemberaddress = grievance.getFedmember().getAddress();
			getHibernateTemplate().save(fedmemberaddress);
			Member fedmember = grievance.getFedmember();
			fedmember.setAddress_id(fedmemberaddress.getAddress_id());
			getHibernateTemplate().save(fedmember);
			grievance.setFed_member_id(fedmember.getMember_id());

			// Grievance Info
			getHibernateTemplate().save(grievance);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	public Grievance trackGrievance(Grievance grievance) {

		System.out.print("Retrieving Grievance Details ");
		Query query = getSession().getNamedQuery("grievance.trackGrievnace");
		query.setInteger("grievanceId", grievance.getGrievance_id());
		query.setString("email", grievance.getContact_email());
		query.setString("ssn", grievance.getSsn());
		Grievance trackgrievance = (Grievance) query.uniqueResult();
		return trackgrievance;

	}

	public Grievance getGrievanceDetails(Grievance grievance) {
		Grievance grievanceDetails = null;
		System.out.print("Retrieving Grievance Details ");
		if (null != grievance.getSsn()) {
			Query query = getSession().getNamedQuery(
					"grievance.getGrievanceBySSN");
			query.setString("ssn", grievance.getSsn());
			grievanceDetails = (Grievance) query.uniqueResult();
		} else if (0 != grievance.getGrievance_id()) {
			Query query = getSession().getNamedQuery(
					"grievance.getGrievanceByID");
			query.setInteger("grievanceId", grievance.getGrievance_id());
			grievanceDetails = (Grievance) query.uniqueResult();
		}
		// query.setString("email", grievance.getContact_email());

		return grievanceDetails;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grievance> getAllGrievances() {
		System.out.print("Retrieving Grievance Details ");
		Query query = getSession().getNamedQuery("grievance.getAllGrievances");
		List<Grievance> trackgrievance = query.list();
		return trackgrievance;

	}
}
