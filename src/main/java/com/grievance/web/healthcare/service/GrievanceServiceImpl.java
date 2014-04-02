package com.grievance.web.healthcare.service;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grievance.web.healthcare.newmodel.Address;
import com.grievance.web.healthcare.newmodel.Grievance;
import com.grievance.web.healthcare.newmodel.Member;

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
}
