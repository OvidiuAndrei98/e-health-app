import axios from "axios";
import AuthHeader from "./AuthHeader";

const NURSE_API_URL = "http://localhost:8080/nurse";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class NurseService {
  searchNursesForDept(id,search) {
    return axios.get(`${NURSE_API_URL}/search-nurses/${id}/${search}`, {headers: AuthHeader()});
  };

  getAllNurses() {
    return axios.get(`${NURSE_API_URL}/nurses`, {headers: AuthHeader()});
  };

  getAllNursesForDept(id) {
    return axios.get(`${NURSE_API_URL}/nurses/${id}`, {headers: AuthHeader()});
  };

  getNurseForPatient(id){
    return axios.post(`${NURSE_API_URL}/nurse-for-patient/${id}`, {headers: AuthHeader()});
}

}

export default new NurseService();