import { BrowserRouter as Router, Redirect, Route, Routes} from "react-router-dom";
import HomePage from './HomePage';
import Departments from "../departments/Departments";
import Login from "../auth/Login";

const Routing = () => {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/" exact element={<HomePage/>} />
                    <Route path="/departments" exact element={<Departments/>} />
                    <Route path="/login" exact element={<Login/>} />

                </Routes>
            </Router>
        </>
    );
}

export default Routing;