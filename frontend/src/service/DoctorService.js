import axios from "axios";
import AuthHeader from "./AuthHeader";

const DOCTOR_API_URL = "http://localhost:8080/doctor";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class DoctorService {
  getAllDoctors() {
    return axios.get(`${DOCTOR_API_URL}/doctors`, {headers: AuthHeader()});
  };

  getAllDoctorsForDept(id) {
    return axios.get(`${DOCTOR_API_URL}/doctors/${id}`, {headers: AuthHeader()});
  };

  searchDoctor(search) {
    return axios.get(`${DOCTOR_API_URL}/search/${search}`, {headers: AuthHeader()});
  };

  getDoctorForPatient(id){
      return axios.post(`${DOCTOR_API_URL}/doctor-for-patient/${id}`, {headers: AuthHeader()});
  }


}

export default new DoctorService();