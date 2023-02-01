infra:
	@docker-compose up -d

infra-down:
	@docker-compose down --remove-orphans