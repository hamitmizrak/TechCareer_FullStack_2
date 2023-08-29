
// rcc
import React, { Component } from 'react'

// I18N
import { withTranslation } from 'react-i18next';

// Footer Css
import './footer.css';

// CLASS COMPONENT
class Footer extends Component {

    // Component görünen ismi
    static displayName = "Blog_Footer";

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
                <footer className="bg-light text-center text-lg-start fixed-bottom">
                    {/* Copyright */}
                    <div
                        className="text-center p-3 footer_class"
                        style={{ backgroundColor: "rgba(0, 0, 0, 0.9)" }}
                    >
                        {this.props.copy}
                        <a className="text-dark" href="https://"
                            style={{ backgroundColor: "rgba(255, 255, 255, 0.9)" }}>
                            Blog
                        </a>
                    </div>
                    {/* Copyright */}
                </footer>

            </React.Fragment>
        ) //end return
    } //end render
} //end class

// Higher Order Component
export default withTranslation()(Footer);
