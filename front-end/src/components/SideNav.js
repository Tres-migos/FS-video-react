import React, { Component } from 'react'
import { Menu, Image, Button } from 'semantic-ui-react'
import { Link } from 'react-router-dom'




export default class SideNav extends Component {
  state = { activeItem: 'trending' }

  handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
    const { activeItem} = this.state
    

    return (
      <>

        <Menu secondary vertical>
         
          <Menu.Item
            name='home'
            active={activeItem === 'home'}
            onClick={this.handleItemClick}
            as={Link}
          >
            <Link to="/">Home</Link>
          
            </Menu.Item>
          
          <Menu.Item
            name='my-uploads'
            active={activeItem === 'music'}
            onClick={this.handleItemClick}
            as={Link}
          >
            <Link to="/my-uploads">My Uploads</Link>
            </Menu.Item>
        
        
          <Menu.Item
            name='video-games'
            active={activeItem === 'video-games'}
            onClick={this.handleItemClick}
            as={Link}
          >
            <Link to="/video-games">Video Games</Link>   
            </Menu.Item>

          <Menu.Item
            name='music'
            active={activeItem === 'music'}
            onClick={this.handleItemClick}
            as={Link}
          >
            <Link to="/music">Music</Link>
            </Menu.Item>

        </Menu>
        
      </>
        
    )
  }
}
