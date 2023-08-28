// AXIOS
import axios from "axios";

// Persist URL 
const CATEGORY_URL = "/category/api/v1"

// CLASS API
class CategoryApi {

    // CREATE
    // http://localhost:4444/category/api/v1/create
    // @PostMapping("/create")</CategoryDto>
    categoryApiCreate(categoryDto) {
        return axios.post(`${CATEGORY_URL}/create`, categoryDto)
    };

    // LIST
    // @GetMapping(value="/list")
    // http://localhost:4444/category/api/v1/list
    categoryApiList() {
        return axios.get(`${CATEGORY_URL}/list`)
    }

    // FIND
    // http://localhost:4444/category/api/v1/find/1
    //@GetMapping(value="/find/{id}")
    categoryApiFindById(id) {
        return axios.get(`${CATEGORY_URL}/find/${id}`)
    }

    // UPDATE
    // http://localhost:4444/category/api/v1/update/1
    //@PutMapping(value="/update/{id}")
    categoryApiUpdate(id, categoryDto) {
        return axios.put(`${CATEGORY_URL}/update/${id}`, categoryDto)
    }

    // DELETE BY ID
    // http://localhost:4444/category/api/v1/delete/1
    //@DeleteMapping(value="/delete/{id}")
    categoryApiDeleteById(id) {
        return axios.delete(`${CATEGORY_URL}/delete/${id}`)
    }

} //end class

export default new CategoryApi();
