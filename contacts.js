import React, {Component} from 'react';
import resumeData from "../../resumeData";
import logo from '../../logo.svg';

export default class Contact extends Component {
    render() {
        return (
            <React.Fragment>
                <section id="contact">
                    <div className="row section-head">
                        <div className="two columns header-col">
                            <h1><span>Get In Touch.</span></h1>
                        </div>
                        <div className="ten columns">
                            <p className="lead">
                                If you have any questions, send me message ...
                            </p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="six columns">
                            <form action="mailto:marektomas.mt@gmail.com" method="GET" target="_blank">
                                <fieldset>
                                    <div>
                                        <input name="subject" size={35} type="text" placeholder="Subject"/>
                                    </div>
                                </fieldset>
                                <textarea name="body" placeholder="Body"/>
                                <input type="submit" value="Send email"/>
                            </form>
                        </div>
                        <aside className="five columns footer-widgets">
                            <div className="widget widget_contact">
                                <h4>Address and Phone</h4>
                                <p className="address">
                                    {resumeData.name}<br/>
                                    {resumeData.street}<br/>
                                    {resumeData.city}<br/>
                                    {resumeData.phone}<br/>
                                </p>
                            </div>
                            <div className="widget widget_tweets">
                                <img src={logo} className="App-logo" alt="logo"/>
                            </div>
                        </aside>
                    </div>
                </section>
            </React.Fragment>
        );
    }
}