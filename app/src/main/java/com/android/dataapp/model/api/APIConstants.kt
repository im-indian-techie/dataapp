package com.example.parkzapp.model.api

import android.media.session.MediaSession.Token

class APIConstants {
    companion object {
        const val BASE_URL="https://app.iformbuilder.com/"////private-anon-8e412ed899-iformbuilder.apiary-proxy.com
        const val ACCESS_TOKEN="oauth2/token"
        const val FETCH_DATA="exzact/api/v60/profiles/{profile_id}/pages"
        const val MY_DATA="exzact/api/v60/profiles/{profile_id}/pages/{pageid}/records"
        const val JWT="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJPU1dYVTZXc1FKb09hZFpVRVhONTlYUlJHR2wxYnR0QWR2ZGVIbDVJLmR0THEyY1YyNHZzNVZOaVV5cGYwIiwiYXVkIjoiaHR0cHM6Ly96ZXJpb25zb2Z0d2FyZS5pZm9ybWJ1aWxkZXIuY29tL2V4emFjdC9hcGkvb2F1dGgvdG9rZW4iLCJleHAiOjE3MDg3ODA4MTUsImlhdCI6MTcwODc4MDgwNX0.49tcxEeu3EDUWvPRaljFBa3WbLr6Vh7q6mMIU-edVrE"
        const val CLIENT_ID="tovzXavr97CxTc4WB37CGL9hprAxmlx4DP6mbIr1"
        const val CLIENT_SECRET="prN324nR4DyndpQiA0GdNkNOOubt0OpB6QHBd6rA"
        const val ACESS_TOKEN="fy2FYmnwlrdFERDTWih3JVZddCbtSZXoVL3nS0BW.7TwR5N5MVbLCpbW3AQy8Tlk9gt77JchXoMc8Vlmy"
    }
}