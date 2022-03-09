import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './styles.css';

function Navbar () {
    return (
        <header>
        <nav className='container'>
          <div className='dsmovie-nav-content'>
            <h1>DSMovie</h1>
            <div className='dsmovie-contact-container'>
              <GithubIcon/>
              <p className='dsmovie-contact-link'>/LudmyllaArielly</p>
            </div>
          </div>
        </nav>
      </header> 
    );
}

/*Exporta a funcao*/
export default Navbar;