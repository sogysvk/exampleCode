import React, { Component } from 'react';
import resumeData from "../../resumeData";
export default class Header extends Component {
    render() {
        return (
            <React.Fragment>
                <header id="home">
                    <nav id="nav-wrap">
                        <a className="mobile-btn" href="#nav-wrap" title="Show navigation">Show navigation</a>
                        <a className="mobile-btn" href="#" title="Hide navigation">Hide navigation</a>
                        <ul id="nav" className="nav">
                            <li className="current"><a className="smoothscroll" href="#home">Home</a></li>
                            <li><a className="smoothscroll" href="#about">About</a></li>
                            <li><a className="smoothscroll" href="#experience">Experience</a></li>
                            <li><a className="smoothscroll" href="#hobby">Hobby</a></li>
                            <li><a className="smoothscroll" href="#ideas">Ideas</a></li>
                            <li><a className="smoothscroll" href="#contact">Contact</a></li>
                        </ul> {/* end #nav */}
                    </nav> {/* end #nav-wrap */}
                    <div className="row banner">
                        <div className="banner-text">
                            <h1 className="responsive-headline">I'm {resumeData.name}</h1>
                            <h3>I'm {resumeData.role}.
                                {resumeData.description}.
                                <p>Let's <a className="smoothscroll" href="#about">start scrolling </a>
                                and learn more <a className="smoothscroll" href="#experience">about me</a>.</p></h3>
                            <hr />
                            <ul className="social">
                                <li><a href="https://www.facebook.com/marektomas.mt" target="_blank">
                                    <i className="fa fa-facebook" /></a></li>
                                <li><a href="https://www.linkedin.com/in/marek-tom%C3%A1%C5%A1-23a80776" target="_blank">
                                    <i className="fa fa-linkedin" /></a></li>
                                <li><a href="https://github.com/sogysvk" target="_blank">
                                    <i className="fa fa-github" /></a></li>
                                <li><a href="#"><i className="fa fa-skype" /></a></li>
                            </ul>
                        </div>
                    </div>
                    <p className="scrolldown">
                        <a className="smoothscroll" href="#about"><i className="icon-down-circle" /></a>
                    </p>
                </header> {/* Header End */}

            </React.Fragment>
        );
    }
}