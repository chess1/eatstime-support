import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'basscss/css/basscss.min.css';
import App from './App';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import { unregister } from './registerServiceWorker';

const AppContainer = () => (
    <MuiThemeProvider>
        <App/>
    </MuiThemeProvider>
);

ReactDOM.render(<AppContainer/>, document.getElementById('root'));
unregister();
