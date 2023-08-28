import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

// FUNCTION
export default function CategoryList() {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [CategoryStateApi, setCategoryStateApi] = useState([]);

  // USEEFFECT
  useEffect(() => {
    axios.get("http://localhost:4444/category/api/v1/list")
      .then((response) => {
        console.log(response.data);
        setCategoryStateApi(response.data);
      })
      .catch((err) => { console.error(err); });
  }, []);


  // LIST
  const getListCategory = (() => {
    axios.get("http://localhost:4444/category/api/v1/list")
      .then((response) => {
        console.log(response.data);
        setCategoryStateApi(response.data);
      })
      .catch((err) => { console.error(err); });
  });

  // DELETE
  const setDeleteCategory = ((id) => {
    if (window.confirm("Silmek istediğinizden emin misiniz ?")) {
      axios.delete("http://localhost:4444/category/api/v1/delete/" + id)
        .then(() => {
          getListCategory();
        })
    } else {
      alert("Silinmedi.")
    }
    navigate("/category/list");
  });

  //UPDATE
  const setUpdateCategory = (data) => {
    let { id, categoryName, systemDate } = data;
    localStorage.setItem("category_update_id", id);
    localStorage.setItem("category_update_category_name", categoryName);
    localStorage.setItem("category_update_category_date", systemDate);
  }

  //VIEW
  const setViewCategory = (id) => {
    localStorage.setItem("category_view_id", id);
  }

  //RETURN
  return (
    <React.Fragment>
      <h1 className="text-center display-3">Category List</h1>
      <Link to="/category/create" className="btn btn-primary">Category Ekle</Link>
      <table className="table table-striped table-hover table-responsive">
        <thead>
          <tr>
            <th>ID</th>
            <th>CATEGORY NAME</th>
            <th>DATE</th>
            <th>UPDATE</th>
            <th>VIEW</th>
            <th>DELETE</th>
          </tr>
        </thead>
        <tbody>
          {
            CategoryStateApi.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.categoryName}</td>
                <td>{data.systemDate}</td>

                <td>
                  <Link to="/category/update">
                  <i onClick={()=>setUpdateCategory(data)} class="fa-solid fa-pen-to-square text-primary"></i>
                  </Link>
                  </td>

                <td>
                <Link to="/category/view">
                  <i onClick={()=>setViewCategory(data.id)} class="fa-solid fa-expand text-warning"></i>
                  </Link>
                  </td>

                <td>
                <Link to="/category/delete">
                  <i onClick={()=>setDeleteCategory(data.id)} class="fa-solid fa-trash text-danger"></i>
                  </Link>
                  </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </React.Fragment>
  )
}
