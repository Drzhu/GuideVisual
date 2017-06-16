package com.guide.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backup.CommunityDateCourseReg;
import com.backup.CommunityDetailInfo;
import com.backup.CommunityDoc;
import com.backup.CommunityHospital;
import com.backup.CommunityKecheng;
import com.backup.CommunityKechengDoctorPatient;
import com.backup.CommunityKechengPatientViewer;
import com.backup.CommunityKeshi;
import com.guide.ascvd.pojo.ASCVD;
import com.guide.ascvd.pojo.DoctorDetail;
import com.guide.ascvd.service.AscvdService;
import com.guide.community.pojo.Community;
import com.guide.community.service.CommunityService;
import com.guide.utils.JsonUtil;

@Controller
@RequestMapping("/")
public class MobileController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat fmr = new SimpleDateFormat("MM-dd");
	DecimalFormat df = new DecimalFormat();
	
	@Resource(name = "AscvdService")
	private AscvdService ascvdService;
	
	@Resource(name = "CommunityService")
	private CommunityService communityService;
	
	
	private Logger logger;

	public MobileController() {
		this.logger = Logger.getLogger(MobileController.class);
	}
	//全国医生获取省内各市
	@RequestMapping(value = "getcity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getcity_data(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		selectedProvince = java.net.URLDecoder.decode(selectedProvince, "UTF-8");
		List<ASCVD> list = ascvdService.getDoctorByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}
	//全国医院获取省内各市数据
	@RequestMapping(value = "gethoscity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String gethoscity_data(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		selectedProvince = java.net.URLDecoder.decode(selectedProvince, "UTF-8");
		List<ASCVD> list = ascvdService.getDoctorByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}
	//立普妥-搜索按钮跳转
	@RequestMapping(value = "mobile_lpt_info", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String query(HttpServletRequest request) {
		return "mobile/query_lpt1";
	}
	//社区医生-搜索按钮跳转
	@RequestMapping(value = "mobile_community_info", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String community_query(HttpServletRequest request) {
		return "mobile/query_community";
	}
	//手机端入口
	@RequestMapping(value = "open", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String main(HttpServletRequest request) {
		return "mobile/mobile_go";
	}
	//立普妥主页
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "mobile_lpt1", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String mobile_lpt1(HttpServletRequest request) {
		List<ASCVD> doc_prov = ascvdService.queryDoctorProv();
		List<ASCVD> doc_city = ascvdService.queryDoctorCity();
		List<ASCVD> hos_prov = ascvdService.queryDoctorProv();
		List<ASCVD> hos_city = ascvdService.queryDoctorCity();
		List<ASCVD> keshi_list = ascvdService.queryKeShi();
		List<ASCVD> course_list = ascvdService.queryCourse();
		List<ASCVD> datecoursereg_list = ascvdService.queryDateCourseReg();
		List<ASCVD> CourseDoctorPatient_list = ascvdService.queryCourseDoctorPatient();
		List<ASCVD> CoursePatientViewer_list = ascvdService.queryCoursePatientViewer();
		JSONArray Doc_arr_prov = new JSONArray();
		for (ASCVD doc : doc_prov) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_prov.add(Doc_obj);
		}
		JSONArray Doc_arr_city = new JSONArray();
		for (ASCVD doc : doc_city) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_city.add(Doc_obj);
		}
		JSONArray Hos_arr_prov = new JSONArray();
		for (ASCVD hos : hos_prov) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_prov.add(Hos_obj);
		}
		JSONArray Hos_arr_city = new JSONArray();
		for (ASCVD hos : hos_city) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_city.add(Hos_obj);
		}
		request.setAttribute("Doc_prov", Doc_arr_prov);
		request.setAttribute("Doc_prov1", Doc_arr_prov.toJSONString());
		request.setAttribute("Doc_city", Doc_arr_city);
		request.setAttribute("Doc_city1", Doc_arr_city.toJSONString());
		request.setAttribute("Hos_prov", Hos_arr_prov);
		request.setAttribute("Hos_prov1", Hos_arr_prov.toJSONString());
		request.setAttribute("Hos_city", Hos_arr_city);
		request.setAttribute("Hos_city1", Hos_arr_city.toJSONString());
		request.setAttribute("Pie_keshi", keshi_list);
		request.setAttribute("Pie_course", course_list);
		request.setAttribute("Line_date", datecoursereg_list);
		request.setAttribute("Bar_doctor", CourseDoctorPatient_list);
		request.setAttribute("Bar_viewer", CoursePatientViewer_list);
		return "mobile/mobile_lpt1";
	}
	//社区主页
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "mobile_community", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String mobile_lpt2(HttpServletRequest request) {
		List<Community> doc_prov = communityService.queryDoctorProv();
		List<Community> doc_city = communityService.queryDoctorCity();
		List<Community> hos_prov = communityService.queryHospitalProv();
		List<Community> hos_city = communityService.queryHospitalCity();
		List<Community> keshi_list = communityService.queryKeShi();
		List<Community> course_list = communityService.queryCourse();
		List<Community> datecoursereg_list = communityService.queryDateCourseReg();
		List<Community> CourseDoctorPatient_list = communityService.queryCourseDoctorPatient();
		List<Community> CoursePatientViewer_list = communityService.queryCoursePatientViewer();
		JSONArray Doc_arr_prov = new JSONArray();
		for (Community doc : doc_prov) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_prov.add(Doc_obj);
		}
		JSONArray Doc_arr_city = new JSONArray();
		for (Community doc : doc_city) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_city.add(Doc_obj);
		}
		JSONArray Hos_arr_prov = new JSONArray();
		for (Community hos : hos_prov) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_prov.add(Hos_obj);
		}
		JSONArray Hos_arr_city = new JSONArray();
		for (Community hos : hos_city) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_city.add(Hos_obj);
		}
		request.setAttribute("Doc_prov", Doc_arr_prov);
		request.setAttribute("Doc_prov1", Doc_arr_prov.toJSONString());
		request.setAttribute("Doc_city", Doc_arr_city);
		request.setAttribute("Doc_city1", Doc_arr_city.toJSONString());
		request.setAttribute("Hos_prov", Hos_arr_prov);
		request.setAttribute("Hos_prov1", Hos_arr_prov.toJSONString());
		request.setAttribute("Hos_city", Hos_arr_city);
		request.setAttribute("Hos_city1", Hos_arr_city.toJSONString());
		request.setAttribute("Pie_keshi", keshi_list);
		request.setAttribute("Pie_course", course_list);
		request.setAttribute("Line_date", datecoursereg_list);
		request.setAttribute("Bar_doctor", CourseDoctorPatient_list);
		request.setAttribute("Bar_viewer", CoursePatientViewer_list);
		return "mobile/mobile_community";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "lpt_datatable_query", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String lpt_datatable_query(HttpServletRequest request, @RequestParam("search[value]") String search,
			@RequestParam("draw") int draw, @RequestParam("start") int start) throws Exception {
		/*String str = new String((request.getParameter("search[value]")).getBytes("iso-8859-1"), "utf-8");*/
		String str = request.getParameter("search[value]");
		if (str.contains("\"")) {
			str = str.replace(str.substring(str.indexOf("\""), str.length()), "");
		}
		int len = ascvdService.dataTableDoctorDetailCount(str);
		List<DoctorDetail> list = ascvdService.dataTableDoctorDetail(start, str);
		JSONObject json = new JSONObject();
		List<List<String>> list1 = new ArrayList<List<String>>();
		List<String> list2 = new ArrayList<String>();

		for (DoctorDetail i : list) {
			list2.add(i.getCityName());
			list2.add(i.getDoctorName());
			list2.add(i.getHospitalName());
			list2.add(i.getKeShiName());
			list1.add(list2);
			list2 = new ArrayList<String>();
		}
		json.put("data", list1);
		json.put("recordsTotal", len);
		json.put("recordsFiltered", len);
		json.put("draw", draw);
		return json.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "community_datatable_query", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String community_datatable_query(HttpServletRequest request, @RequestParam("search[value]") String search,
			@RequestParam("draw") int draw, @RequestParam("start") int start) throws Exception {
		/*String str = new String((request.getParameter("search[value]")).getBytes("iso-8859-1"), "utf-8");*/
		String str = request.getParameter("search[value]");
		if (str.contains("\"")) {
			str = str.replace(str.substring(str.indexOf("\""), str.length()), "");
		}
		int len = communityService.dataTableDoctorDetailCount(str);
		List<DoctorDetail> list = communityService.dataTableDoctorDetail(start, str);
		JSONObject json = new JSONObject();
		List<List<String>> list1 = new ArrayList<List<String>>();
		List<String> list2 = new ArrayList<String>();

		for (DoctorDetail i : list) {
			list2.add(i.getCityName());
			list2.add(i.getDoctorName());
			list2.add(i.getHospitalName());
			list2.add(i.getKeShiName());
			list1.add(list2);
			list2 = new ArrayList<String>();
		}
		json.put("data", list1);
		json.put("recordsTotal", len);
		json.put("recordsFiltered", len);
		json.put("draw", draw);
		return json.toJSONString();

	}
}
