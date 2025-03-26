Pre Assessment(Day-1): https://forms.office.com/r/rQcesmSiJb

resilience4j.circuitbreaker:
    instances:
        backendB:
            registerHealthIndicator: true
            slidingWindowSize: 10
            permittedNumberOfCallsInHalfOpenState: 3
            slidingWindowType: COUNT_BASED
            minimumNumberOfCalls: 5
            waitDurationInOpenState: 50s
            failureRateThreshold: 50
            eventConsumerBufferSize: 10
            automaticTransitionFromOpenToHalfOpenEnabled: true
