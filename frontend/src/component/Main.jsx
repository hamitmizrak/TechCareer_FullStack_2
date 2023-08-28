import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Main extends Component {
  render() {
    return (
      <React.Fragment>
        <h1 className="display-3">Ana Sayfa</h1>
         <Link className="btn btn-primary mt-5 mb-5" to="category/list">Category - List</Link>
      </React.Fragment>
    )
  }
}
