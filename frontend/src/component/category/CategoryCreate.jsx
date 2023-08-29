import React, { useState } from 'react'
import { withTranslation } from 'react-i18next'
import { useNavigate } from 'react-router-dom'
import CategoryApi from '../../services/CategoryApi';


// FUNCTION
 function CategoryCreate({t}) {

  // REDIRECT
  const navigate=useNavigate();

  // STATE
  const [categoryName, setCategoryName] = useState('');

  // POST
  const categoryPost=(event)=>{
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();

    // Category object
    const newCategory={
      categoryName
    }
    console.log(newCategory);

    // API
    CategoryApi.categoryApiCreate(newCategory)
    .then((response)=>{
      if (response.status===200){
        navigate('/category/list');
      }
    })
    .catch((err)=>{
      console.error(err);
    });

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
          onChange={(event)=>{setCategoryName(event.target.value)}}
          />
          </div>
          <button type='submit' className="btn btn-primary mt-3" onClick={categoryPost}>{t('create')}</button>
      </form>
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion

// i18n wrapper
export default withTranslation()(CategoryCreate)