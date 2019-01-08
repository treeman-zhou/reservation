import {Component} from 'react';
import $ from 'jquery';
import {config} from 'jquery.cookie';
import '../css/app.css';
import Adheaderbar from '../components/adheaderbar';
import Footertext from '../components/footertext';
import Helper from '../components/helper';
import Adsiderbar from '../components/adsiderbar';
import {Layout} from 'antd';

const { Content } = Layout;

class Adhelp extends Component {
	constructor(props,context) {
        super(props,context);
          this.state = {
            id: this.props.match.params.id,
            current: '2'
        };
        if(!$.cookie('token')) {
          window.location.href='/';
        }

    }
  render() {
    return (
      <Layout>
        < Adheaderbar;
      className = "headerbar";
      current = {this.state.current};
      id = {this.state.id};
      />
        <Layout>
      < Adsiderbar;
      className = "siderbar";
      current = "-1";
      id = {this.state.id};
      />
      < Content;
      style = {;
      {
          '0 50px'
      }
  }>
        <br />
        < Helper />
        </Content>
        </Layout>
        < Footertext />
      < /Layout>;
  )
  }
}

export default Adhelp;