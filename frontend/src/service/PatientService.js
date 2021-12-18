import axios from "axios";

const PATIENT_API_URL = "http://localhost:8080/patient";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class PatientService {
  savePatient(patient,patientDoctor, patientNurse) {
    
    return axios.post(`${PATIENT_API_URL}/save`, patient);
  };

}

export default new PatientService();