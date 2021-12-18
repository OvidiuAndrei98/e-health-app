import { BrowserRouter as Router, Redirect, Route, Routes} from "react-router-dom";
import HomePage from './HomePage';
import Departments from "../departments/Departments";

const Routing = () => {
    return (
        <>
            <Router>
                <Routes>
                    <Route path="/" exact element={<HomePage/>} />
                    <Route path="/departments" exact element={<Departments/>} />
                </Routes>
            </Router>
        </>
    );
}

export default Routing;