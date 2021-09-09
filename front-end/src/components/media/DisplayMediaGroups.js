import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Dimmer, Loader, Image, Segment, Grid } from 'semantic-ui-react'
import DisplayMedia from './DisplayMedia'

const instance = axios.create({
    baseURL: 'http://localhost:8080/video',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
  });

const DisplayMediaGroups = () => {
    const [trendingVideos, setTrendingVideos] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const handleLoader = () => {
        setLoading(isLoading => !isLoading)
    }

    const getAllTrendingMedia = async () => {
        handleLoader()
        let s3objects = []
        s3objects = await instance.get("/all")
        setTrendingVideos(s3objects.data.objectSummaries)
    }

    

    useEffect(() => {
        getAllTrendingMedia()
        handleLoader()
    }, [])

    return (
        <>
            {
                isLoading && trendingVideos == null &&
                <Grid columns={4} fluid>
                    <Grid.Row>
                        <Grid.Column>
                            <Segment>
                                <Dimmer active>
                                    <Loader size='large'>Loading</Loader>
                                </Dimmer>
                            </Segment>
                        </Grid.Column>
                    </Grid.Row>
                </Grid>
            }            

            {
                !isLoading && trendingVideos != null &&
                <Grid columns={4} fluid padded>
                      <Grid.Row>
                        {trendingVideos.map((e, i) => {
                            return (
                                <Grid.Column key={i}>
                                    <DisplayMedia media={e} />
                                </Grid.Column>
                            )
                        })}
                        </Grid.Row>
                </Grid>
            }
        </>

    )


}

export default DisplayMediaGroups