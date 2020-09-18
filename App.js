import React, {Component} from 'react';
import './App.css';
import Header from './components/header/header';
import About from './components/about/about';
import Experience from './components/experience/experience';
import Hobby from './components/hobby/hobby';
import Ideas from './components/ideas/ideas';
import Contacts from './components/contacts/contacts';
import Footer from './components/footer/footer';
import resumeData from './resumeData';

class App extends Component {
    render() {
        return (
            <div className="App">
                <Header resumeData={resumeData}/>
                <About/>
                <Experience/>
                <Hobby/>
                <Ideas/>
                <Contacts/>
                <Footer/>
            </div>
        );
    }
}

export default App;
