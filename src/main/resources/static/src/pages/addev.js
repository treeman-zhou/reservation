import React, { Component } from 'react';
import '../css/app.css';
import logo from '../images/logo.png';
import Adheaderbar from '../components/adheaderbar';
import Adsiderbar from '../components/adsiderbar';
import Footertext from '../components/footertext';
import Devline from '../components/devline';
import { Layout } from 'antd';
const { Content } = Layout;

class Addev extends Component {
  constructor(props,context) {
        super(props,context);
          this.state = {
            current: '3',
            id: this.props.match.params.id
        };
    }
  render() {
    return (
      <Layout>
        < Adheaderbar className="headerbar" current = { this.state.current } id={this.state.id}/>
        <Layout>
        < Adsiderbar className="siderbar" current="-1" id={this.state.id}/>
        <Content style={{ padding: '0 50px' }}>
        <br />
        < Devline />
        </Content>
        </Layout>
        < Footertext />
      </Layout>
    );
  }
}

export default Addev;