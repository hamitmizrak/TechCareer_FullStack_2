// REACT
import React, { useState } from 'react'

// LANGUAGE
import { withTranslation } from 'react-i18next'

// ROUTER 
import { useNavigate } from 'react-router-dom'

// API
import CategoryApi from '../../services/CategoryApi';


// FUNCTION
function CategoryCreate({ t }) {

  // REDIRECT
  const navigate = useNavigate();

  // STATE
  const [categoryName, setCategoryName] = useState('');
  const [validationErrors, setValidationErrors] = useState({});

  // CREATE
  const categoryCreate = (event) => {
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();

    // Category object
    const newCategory = {
      categoryName
    }
    console.log(newCategory);

    // API
    CategoryApi.categoryApiCreate(newCategory)
      .then((response) => {
        if (response.status === 200) {
          navigate('/category/list');
        }
      })
      .catch((err) => {
        console.error(err);
      });
  }


  // CHANGE
  const categoryOnChange = (event) => {
    const { name, value } = event.target;
    //console.log(`${name} => ${value}`);

    // onChange
    setCategoryName(event.target.value);
   
    const backendErrorHandling={...validationErrors};
    console.log(backendErrorHandling);
    backendErrorHandling[name]=undefined;
   setValidationErrors(backendErrorHandling);

  }


  // RETURN
  return (
    <React.Fragment>
      <form>
        <h2 className="display-3 mt-4">{t('category_name')}</h2>
        <div className="form-group">
          <span>{t('category_name')}</span>
          <input
            type="text"
            className="form-control"
            placeholder={t('category_name')}
            required={true}
            autoFocus={true}
            id="category_data"
            name="category_data"
            onChange={categoryOnChange}
          //onChange={(event)=>{setCategoryName(event.target.value)}}
          />
          <span className="text-danger">asd</span>
        </div>
        <button 
        type='submit' 
        className="btn btn-primary mt-3"
        disabled={!true}
        onClick={categoryCreate}>{t('create')}</button>
      </form>
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion

// i18n wrapper
export default withTranslation()(CategoryCreate)