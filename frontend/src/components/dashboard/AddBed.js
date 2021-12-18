import React,{useEffect} from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { makeStyles } from '@mui/styles';
import RoomService from '../../service/RoomService';
import Button from '@mui/material/Button';


const AddBed = ({departmentId}) => {
    const [roomId, setRoomId] = React.useState(null);
    const [rooms, setRooms] = React.useState([]);

    useEffect(() => {
        RoomService.getAllRoomsForDepartment(departmentId).then(res => {
            setRooms(res.data);
        });
    } , []);

    const useStyles = makeStyles((theme) => ({
        root: {
            height: 50,
              "& .MuiInputLabel-root.Mui-focused": {
                color: "#798BF2"
              },
              "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
                borderColor: "#798BF2"
              }
          },
      }));
    
      const classes = useStyles();

      const handleSelect = (event) => {
            setRoomId(event.target.value);
      }

      const addBed = () => {

      }

    return (
        <>
        <div className="center-container">
            <div className="filter-container">
                <FormControl variant="outlined" sx={{ minWidth: "100%" }}>
                    <TextField
                        className={classes.root}
                        size="small"
                        variant="outlined"
                        labelId="rooms"
                        id="rooms"
                        onChange={handleSelect}
                        label="Rooms"
                        select
                    >
                        <MenuItem value="undefined">
                        <em>None</em>
                        </MenuItem>
                        {rooms.map(room => (
                            <MenuItem key={room.id} value={room.id}>{room.id}</MenuItem>
                        ))}
                    </TextField>
                </FormControl>
            </div>
            <Button  style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"30px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"10px"}} onClick = {addBed}>Add Bed</Button>        
        </div>
            
        </>
    );
};

export default AddBed;