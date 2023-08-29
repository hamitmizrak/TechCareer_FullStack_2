
// rcc
import React, { Component } from 'react'

// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom';

// I18N
import { withTranslation } from 'react-i18next';

// HEADER,FOOTER,MAIN
import Footer from './component/Footer';
import Header from './component/Header';
import Main from './component/Main';

// CATEGORY
import CategoryList from './component/category/CategoryList';
import CategoryCreate from './component/category/CategoryCreate';
import CategoryView from './component/category/CategoryView';
import CategoryUpdate from './component/category/CategoryUpdate';


// CLASS COMPONENT
class BlogRouter extends Component {

    // Component görünen ismi
    static displayName = "Blog_Router";

    // Constructor
    constructor(props) {
        super(props);

        // STATE
        this.state = {}

        // BIND
    } //end constructor

    // CDM

    // FUNCTION

    //RENDER
    render() {

        //RETURN
        return (
            <React.Fragment>
                <Header logo="fa-solid fa-warehouse" />

                <div className="container">
                    <Routes>
                        <Route path='/' element={<Main />} />

                        {/* Blog category */}
                        <Route path='/category/list' element={<CategoryList list="category"/>} />
                        <Route path='/category/create' element={<CategoryCreate/>} />
                        <Route path='/category/view/:id' element={<CategoryView/>} />
                        <Route path='/category/update/:id' element={<CategoryUpdate/>} />
                        {/* bad request */}
                        <Route path="*" element={<Navigate to="/" />} />
                    </Routes>
                </div>

                <Footer copy="&copy; 2021 - 2023" />
            </React.Fragment>
        ) //end return
    } //end render
} //end class

// Higher Order Component
export default withTranslation()(BlogRouter);
