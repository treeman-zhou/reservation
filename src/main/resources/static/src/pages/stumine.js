import React, { Component } from 'react';
import { Layout } from 'antd';
import $ from 'jquery';
import { config } from 'jquery.cookie';
import '../css/app.css';
import logo from '../images/logo.png';
import Stuheaderbar from '../components/stuheaderbar';
import Siderbar from '../components/siderbar';
import Mine from '../components/mine';
import Footertext from '../components/footertext';
import req from '../url';
const { Content } = Layout;

class Stumine extends Component {
  constructor(props,context) {
    super(props,context);
    this.state={
      current: 'my',
      id: this.props.match.params.id,
      location: "无",
      number: "无"
    };   
  }

  componentDidMount() {
    $.ajax({
      method: 'GET',
      url: req+'info/'+this.state.id,
      headers: {
        'token': $.cookie('token')
      },
      success: function(res) {
        if(res.code === 0)
        {
          var data = res.data;
          this.setState({
            location: data.location,
            number: data.number
          });
        }
      }.bind(this)
    });
  }
  render() {
    return (
      <Layout className="stupart">
        < Stuheaderbar className="headerbar" current = '-1' id={this.state.id}/>
        < Siderbar className="siderbar" current="my" id={this.state.id}/>
        <Content style={{ padding: '0 50px' }}>
      		<br />
        	<Mine location={this.state.location} number={this.state.number}/>
        </Content>
        < Footertext />
      </Layout>
    );
  }
}

export default Stumine;