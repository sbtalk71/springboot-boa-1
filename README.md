Pre Assessment(Day-1): https://forms.office.com/r/rQcesmSiJb

Post Assessment(Day-5): https://forms.office.com/r/qqVXYTUnPj

 

Feedback Link (Day-5) : https://forms.office.com/r/YeUjrh5wS8

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
