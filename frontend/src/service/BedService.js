import axios from "axios";

const BED_API_URL = "http://localhost:8080/bed";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class BedService {
  getAllBedsForRoom(roomId) {
    return axios.get(`${BED_API_URL}/beds/${roomId}`);
  };


}

export default new BedService();