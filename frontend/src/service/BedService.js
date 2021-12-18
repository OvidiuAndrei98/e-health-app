import axios from "axios";
import AuthHeader from "./AuthHeader";

const BED_API_URL = "http://localhost:8080/bed";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class BedService {
  getAllBedsForRoom(roomId) {
    return axios.get(`${BED_API_URL}/beds/${roomId}`, {headers: AuthHeader()});
  };

  getEmptyBedsForRoom(roomId) {
    return axios.get(`${BED_API_URL}/beds/${roomId}/empty`, {headers: AuthHeader()});
  };

  addBed(roomId) {
    return axios.put(`${BED_API_URL}/add/${roomId}`, {headers: AuthHeader()});
  };

  addPatient(patient,patientId) {
    return axios.post(`${BED_API_URL}/add/patient/${patientId}`, patient, {headers: AuthHeader()});
  };
}

export default new BedService();