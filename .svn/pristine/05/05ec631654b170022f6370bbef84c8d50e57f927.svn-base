package com.guide.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.ascvd.pojo.DoctorDetail;
import com.guide.community.mapper.CommunityMapper;
import com.guide.community.pojo.Community;

@Service(value="CommunityService")
public class CommunityServiceImpl implements CommunityService{

	@Autowired
	private CommunityMapper communityMapper;

	public List<Community> queryKeShi() {
		// TODO Auto-generated method stub
		return communityMapper.queryKeShi();
	}

	public List<Community> queryCourseDoctorPatient() {
		// TODO Auto-generated method stub
		return communityMapper.queryCourseDoctorPatient();
	}

	public List<Community> queryCourse() {
		// TODO Auto-generated method stub
		return communityMapper.queryCourse();
	}

	public List<Community> queryCoursePatientViewer() {
		// TODO Auto-generated method stub
		return communityMapper.queryCoursePatientViewer();
	}

	public List<Community> queryDateCourseReg() {
		// TODO Auto-generated method stub
		return communityMapper.queryDateCourseReg();
	}

	public List<Community> queryDoctorProv() {
		// TODO Auto-generated method stub
		return communityMapper.queryDoctorProv();
	}

	public List<Community> queryDoctorCity() {
		// TODO Auto-generated method stub
		return communityMapper.queryDoctorCity();
	}

	public List<Community> getDoctorByCity(String selectedProvince) {
		// TODO Auto-generated method stub
		return communityMapper.getDoctorByCity(selectedProvince);
	}

	public List<DoctorDetail> dataTableDoctorDetail(int start,String keshi_name) {
		// TODO Auto-generated method stub
		return communityMapper.dataTableDoctorDetail(start,keshi_name);
	}

	public int dataTableDoctorDetailCount(String str) {
		// TODO Auto-generated method stub
		return communityMapper.dataTableDoctorDetailCount(str);
	}

	public List<Community> queryHospitalProv() {
		// TODO Auto-generated method stub
		return communityMapper.queryHospitalProv();
	}

	public List<Community> queryHospitalCity() {
		// TODO Auto-generated method stub
		return communityMapper.queryHospitalCity();
	}

	public List<Community> getHospitalByCity(String selectedProvince) {
		// TODO Auto-generated method stub
		return communityMapper.getHospitalByCity(selectedProvince);
	}
	
}
