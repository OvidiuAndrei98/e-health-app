import React from 'react';
import BedImage from '../../assets/Bed.png'
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import { makeStyles } from '@mui/styles';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import PatientDetailsModal from './PatientDetailsModal';


const Bed = ({bed}) => {
    const [open, setOpen] = React.useState(false);


    const handleClose = () => setOpen(false);

    const handleOpenModal = () => {
        if(bed.patient != null) {
        setOpen(true);
        }
    }

    const useStyles = makeStyles((theme) => ({
        root: {
            height: 50,
              "& .MuiInputLabel-root.Mui-focused": {
                color: "#798BF2"
              },
              "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
                borderColor: "#798BF2"
              },
              "& .MuiOutlinedInput-notchedOutline": {
                  borderColor: "transparent"
              }
          },
      }));

      const style = {
        position: 'absolute',
        top: '10%',
        left: '31%',
        width: "40%",
        bgcolor: 'background.paper',
        outline: 'none',
        p: 4,
        borderRadius: "5px 5px 0 0",
        };

   
    
      const classes = useStyles();

    return (
        <div className="bed" onClick={handleOpenModal}>
            <img src={BedImage} alt="bed" />
            <p>{bed.id}</p>
            <p>{bed.patient ? bed.patient.name : "Available"}</p>
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
                >
                <Box sx={style}>
                    <PatientDetailsModal bed = {bed} />
                </Box>
            </Modal>
            {/* <div style={{width:"150px"}}>
            <Autocomplete
            disablePortal
            disableClearable
            isOptionEqualToValue={(option, value) => option.label === value.label}
            id={"combo-box-demo" + id}
            onChange={(event, value) => {handleSelect(value)}}
            options={patiens}
            renderInput={(params) => <TextField sx={{width:"100%"}} className={classes.root}  {...params} label={patient ? patient.label : "Available"}/>}
            />
            </div> */}
        </div>
    );
};

export default Bed;